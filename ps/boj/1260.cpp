#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <stack>
using namespace std;

int n,m,start;
vector<vector<int>> v;
vector<bool> visited;

void dfs(int cur){
    int vlen = v[cur].size();
    for(int i=0; i<vlen; ++i){
        int next = v[cur][i];
        if(!visited[next]){
            visited[next] = true;
            cout << next << ' ';
            dfs(next);
        }
    }
}

void dfsUsingStack(int start){
    stack<pair<int, int>> stk;
    stk.push({start,0});
    visited[start] = true;
    cout << start << ' ';
    while(!stk.empty()){
        int cur = stk.top().first;
        int start = stk.top().second;
        stk.pop();
        int vlen = v[cur].size();
        for(int i=start; i<vlen; ++i){
            int next = v[cur][i];
            if(!visited[next]){
                cout << next << ' ';
                visited[next] = true;
                stk.push({cur, i+1}); // 돌던거 
                stk.push({next, 0}); // 새로운 노드
                break;
            }
        }
    }
}

void bfs(int start){
    queue<int> q;
    q.push(start);
    visited[start] = true;
    cout << start << ' ';
    while(!q.empty()){
        int cur = q.front();
        q.pop();
        int vlen = v[cur].size();
        for(int i=0; i<vlen; ++i){
            int next = v[cur][i];
            if(!visited[next]){
                visited[next ] = true;
                cout << next << ' ';
                q.push(next);
            }
        }
    }
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n >> m >> start;
    v = vector<vector<int>>(n+1);
    visited = vector<bool>(n+1, false);
    int a,b;
    for(int i=0; i<m; ++i){
        cin >> a >> b;    
        v[a].push_back(b);
        v[b].push_back(a);
    }
    for(int i=1; i<=n; ++i){
        sort(v[i].begin(), v[i].end());
    }
    
    dfsUsingStack(start);
    cout << '\n';

    visited = vector<bool>(n+1, false); 
    bfs(start);
    return 0;
}