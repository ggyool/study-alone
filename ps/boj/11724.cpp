#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int n, m;
vector<vector<int>> v;
vector<bool> visited;

void dfs(int cur){
    int len = v[cur].size();
    for(int i=0; i<len; ++i){
        int next = v[cur][i];
        if(!visited[next]){
            visited[next] = true;
            dfs(next);
        }
    }    
}

int dfsAll(){
    int ret = 0;
    for(int i=1; i<=n; ++i){
        if(!visited[i]){
            ++ret;
            visited[i] = true;
            dfs(i);
        }
    }
    return ret;
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n >> m;
    v = vector<vector<int>>(n+1);
    visited = vector<bool>(n+1);
    for(int i=0; i<m; ++i){
        int a,b;
        cin >> a >> b;
        v[a].push_back(b);
        v[b].push_back(a);
    }
    cout << dfsAll();
    return 0;
}