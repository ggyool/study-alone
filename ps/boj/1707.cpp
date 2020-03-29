#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

// 양방향이라서 가능
int tc,n, m;
vector<vector<int>> v;
vector<int> gnd;

bool dfs(int cur, int col){
    bool ret = true;
    int len = v[cur].size();
    for(int i=0; i<len; ++i){
        int next = v[cur][i];
        if(gnd[next]==-1){
            gnd[next] = 3-col;
            ret &= dfs(next, 3-col);
        }else if(gnd[next]==col){
            return false;
        }
    }
    return ret;
}

bool dfsAll(){
    bool ret = true;
    for(int i=1; i<=n; ++i){
        if(gnd[i]==-1){
            gnd[i] = 1;
            ret &= dfs(i, 1);
        }
    }
    return ret;
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    cin >> tc;
    while(tc--){
        cin >> n >> m;
        v = vector<vector<int>>(n+1);
        gnd = vector<int>(n+1, -1);
        for(int i=0; i<m; ++i){
            int a,b;
            cin >> a >> b;
            v[a].push_back(b);
            v[b].push_back(a);
        }
        if(dfsAll()) cout << "YES\n";
        else cout << "NO\n";
    }
    
    return 0;
}
