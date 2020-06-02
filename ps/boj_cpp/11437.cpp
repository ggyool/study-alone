#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

// 단순한 방법으로
// lca2 이후에 발전시켜볼거임
int n,m;
vector<vector<int>> v;
vector<int> depth, p;

void calcDepth(int cur){
    int len = v[cur].size();
    for(int i=0; i<len; ++i){
        int next = v[cur][i];
        if(depth[next] == -1){
            p[next] = cur;
            depth[next] = depth[cur] + 1;
            calcDepth(next);
        }
    }
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n;
    v = vector<vector<int>> (n+1);
    depth = vector<int> (n+1, -1);
    p = vector<int> (n+1, -1);
    for(int i=0; i<n-1; ++i){
        int a,b;
        cin >> a >> b;
        v[a].push_back(b);
        v[b].push_back(a);
    }
    depth[1] = 1;
    p[1] = 1;
    calcDepth(1);
    cin >> m;
    for(int i=0; i<m; ++i){
        int a,b;
        cin >> a >> b;
        while(a!=b){
            if(depth[a] < depth[b]){
                b = p[b];
            }
            else if(depth[a] > depth[b]){
                a = p[a];
            }
            else{
                a = p[a];
                b = p[b];
            }
        }
        cout << a << '\n';
    }
    return 0;
}
