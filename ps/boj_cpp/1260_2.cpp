#include <iostream>
#include <cstring>
#include <queue>
#include <algorithm>
using namespace std;

struct Edge{
    int from, to;
    Edge(int from=0, int to=0) : from(from), to(to){}
    bool operator<(const Edge &ref)const{
        if(from==ref.from) return to<ref.to;
        return from<ref.from;
    }
};

int n,m,start;
bool visited[1001];
// 양방향 그래프이므로
Edge edges[20000];
int first[1001];
int last[1001];
const int BIG = 987654321;

void dfs(int cur){
    int left = first[cur];
    int right = last[cur];
    for(int i=left; i<=right; ++i){
        int next = edges[i].to;
        if(!visited[next]){
            visited[next] = true;
            cout << next << ' ';
            dfs(next);
        }
    }
}

void bfs(int start){
    memset(visited, false, sizeof(visited));
    queue<int> q;
    q.push(start);
    visited[start] = true;
    cout << start << ' ';
    while(!q.empty()){
        int cur = q.front();
        q.pop();
        int left = first[cur];
        int right = last[cur];
        for(int i=left; i<=right; ++i){
            int next = edges[i].to;
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
    int a,b;
    for(int i=0; i<m; ++i){
        cin >> a >> b;    
        edges[i].from = a;
        edges[i].to = b;
        edges[i+m].from = b;
        edges[i+m].to = a;
    }
    sort(edges, edges+2*m);
    
    for(int i=1; i<=n; ++i)
        first[i] = BIG;
    // cnt 와 sum 으로 간선리스트를 만들지 않고,
    // first last 를 기억해 보았다.
    for(int i=0; i<2*m; ++i){
        int idx = edges[i].from;
        first[idx] = min(first[idx], i);
        last[idx] = max(last[idx], i);
    }
    visited[start] = true;
    cout << start << ' ';
    dfs(start);
    cout << '\n';
    bfs(start);
    
    return 0;
}