#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int n,m;
vector<vector<int>> v;
vector<int> tin, tout;
vector<bool> visited;
int timer, maxi;

// pp[i][j] i노드의 2**j 번째 부모
// pp[i][j] = pp[pp[i][j-1]][j-1];
int pp[100001][18]; // 2**16=65536

// a가 b보다 위에 있는지
bool upper(int a, int b){
    //if(a==0) return true;
    return (tin[a]<=tin[b] && tout[b]<=tout[a]);
}

void dfs(int cur){
    tin[cur] = ++timer;
    for(int i=1; i<=maxi; ++i){
        pp[cur][i] = pp[pp[cur][i-1]][i-1];
    }
    int len = v[cur].size();
    for(int i=0; i<len; ++i){
        int next = v[cur][i];
        if(!visited[next]){
            visited[next] = true;
            pp[next][0] = cur;
            dfs(next);
        }
    }
    tout[cur] = ++timer;
}

int lca(int a, int b){
    if(upper(a,b)) return a;
    if(upper(b,a)) return b;

    // 다른 그룹인 경우 위에서 부터 체크하여 (당연히 upper인)
    // a가 b의 upper가 아니게 될때 a를 갱신한다.
    for(int i=maxi; i>=0; --i){
        if(!upper(pp[a][i],b)){
            a = pp[a][i];
        }
    }
    return pp[a][0];
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n;
    v = vector<vector<int>> (n+1);
    tin = vector<int> (n+1);
    tout = vector<int> (n+1);
    visited = vector<bool> (n+1, false);
    for(int i=0; i<n-1; ++i){
        int a,b;
        cin >> a >> b;
        v[a].push_back(b);
        v[b].push_back(a);
    }
    // 최대 깊이의 maxi를 구한다.
    for(maxi=1; (1<<maxi)<n; ++maxi);
    --maxi;
    
    visited[1] = true;
    // 넣어야 root보다 위를 체크하는 경우 upper 함수가 true 가 된다.
    tout[0] = 200002; 
    dfs(1);
    cin >> m;
    for(int i=0; i<m; ++i){
        int a,b;
        cin >> a >> b;
        cout << lca(a,b) << '\n';
    }
    return 0;
}
