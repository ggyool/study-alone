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

// 처음 구현
int lca(int a, int b){
    if(depth[a] < depth[b])
        swap(a,b);
    // a 깊이가 더 깊은 상태
    // depth가 같아지도록 a를 올린다.
    // a의 2**i번째 부모가 depth[b]보다 높다면
    // a를 2**i-1 부모로 갱신해주고 또 찾는다.
    // 찾다보면 딱 떨어지는 순간이 온다.
    while(depth[a]!=depth[b]){
        for(int i=0; i<=17; ++i){
            if(depth[a] - (1<<i) == depth[b]){
                a = pp[a][i];
                break;
            }
            else if(depth[a] - (1<<i) < depth[b]){
                a = pp[a][i-1];
                break;
            }
        }
    }
    // 위와 비슷하게 a==b 될때까지 동시에 올린다.
    // 2**i 씩 올리므로 건너뛸수 있다. (a==b 같지만 lca는 아닌)
    // 그런 경우때문에 2**i-1로 갱신을 한다.
    // 2**i가 같은 경우는 lca 가 확실하므로 빠져나온다.
    bool isFind = false;
    if(a==b) isFind = true;
    while(!isFind){
        for(int i=0; i<=17; ++i){
            if(pp[a][i] == pp[b][i]){
                if(i==0) {
                    isFind = true;
                    a = pp[a][i];
                    b = pp[b][i];
                    break;
                }
                else{
                    a = pp[a][i-1];
                    b = pp[b][i-1];
                    break;
                }
            }
        }
    }
    return a;
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
    for(int i=1; i<=n; ++i){
        pp[i][0] = p[i];
    }
    // n이 4이면 j 2 안해도 됨
    // n이 5이면 j 2 해봐야함
    // root 이상으로 올라가면 0이 들어가 있다.
    for(int j=1; (1<<j)<n; ++j){
        for(int i=1; i<=n; ++i){
            pp[i][j] = pp[pp[i][j-1]][j-1];
        }
    }
    cin >> m;
    for(int i=0; i<m; ++i){
        int a,b;
        cin >> a >> b;
        cout << lca(a,b) << '\n';
    }
    return 0;
}
