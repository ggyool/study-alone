#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int n,m;
vector<vector<int>> v;
vector<int> depth, p;

// pp[i][j] i노드의 2**j 번째 부모
// pp[i][j] = pp[pp[i][j-1]][j-1];
int pp[100001][18]; // 2**16=65536

void calcDepth(int cur){
    pp[cur][0] = p[cur];
    for(int j=1; (1<<j)<depth[cur]; ++j){
        pp[cur][j] = pp[pp[cur][j-1]][j-1];
    }
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


int lca(int a, int b){
    
    if(depth[a] < depth[b])
        swap(a,b);
    
    // depth[a] >= depth[b]
    int maxi;
    // 높이보다 2**log 가 커지면 빠져나온 후 -- 한다.
    // (범위를 넘어가지 않는 i번째 부모가 몇인지 구함)
    for(maxi=1; (1<<maxi)<=depth[a]; ++maxi);
    --maxi;
    
    // 큰 부모부터 내려오는 똑똑한 구현
    // depth[a] == depth[b] 이후에는 if 실행 안 된다.
    for(int i=maxi; i>=0; --i){
        if(depth[a] - (1<<i) >= depth[b]){
            a = pp[a][i];
        }
    }
    if(a==b) return a;
    // 그림 그려보면 이해할 수 있다.
    // 같지 않은 부모를 찾으면 lca는 그 위에 있다.
    // 좁혀나가면 lca바로 아래 노드가 나온다.
    for(int i=maxi; i>=0; --i){
        if(pp[a][i]!=pp[b][i]){
            a = pp[a][i];
            b = pp[b][i];
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
    depth = vector<int> (n+1, -1);
    p = vector<int> (n+1, -1);
    for(int i=0; i<n-1; ++i){
        int a,b;
        cin >> a >> b;
        v[a].push_back(b);
        v[b].push_back(a);
    }
    depth[1] = 1;
    p[1] = 0;
    calcDepth(1);
    // // calcDepth 돌며 초기화 해도 된다.
    // for(int i=1; i<=n; ++i){
    //     pp[i][0] = p[i];
    // }
    // for(int j=1; (1<<j)<n; ++j){
    //     for(int i=1; i<=n; ++i){
    //         pp[i][j] = pp[pp[i][j-1]][j-1];
    //     }
    // }
    cin >> m;
    for(int i=0; i<m; ++i){
        int a,b;
        cin >> a >> b;
        cout << lca(a,b) << '\n';
    }
    
    return 0;
}
