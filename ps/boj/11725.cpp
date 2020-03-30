#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int n;
vector<vector<int>> v;
vector<bool> visited;
vector<int> parent;

void dfs(int cur){
    int len = v[cur].size();
    for(int i=0; i<len; ++i){
        int next = v[cur][i];
        if(!visited[next]){
            parent[next] = cur;
            visited[next] = true;
            dfs(next);
        }
    }
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n;
    v = vector<vector<int>> (n+1);
    visited = vector<bool>(n+1);
    parent = vector<int>(n+1);
    for(int i=0; i<n-1; ++i){
        int a,b;
        cin >> a >> b;
        v[a].push_back(b);
        v[b].push_back(a);
    }
    visited[1] = true;
    dfs(1);
    for(int i=2; i<=n; ++i){
        cout << parent[i] << '\n';
    }
    return 0;
}
