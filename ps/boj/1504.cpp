#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;

struct Node{
    int idx, val;
    Node(int _idx, int _val) : idx(_idx), val(_val) {}
    bool operator<(const Node &ref) const{
        return val > ref.val;
    }
};

struct Edge{
    int to, cost;
    Edge(int _to, int _cost) : to(_to), cost(_cost) {}
};


// 핵심 dist[a][b] == dist[b][a]

const int INF = (int)1e7;
int n,e,x,y;
vector<vector<Edge>> v;
vector<int> dist;

void daijkstra(int start){
    priority_queue<Node> pq;
    dist = vector<int> (n+1, INF);
    dist[start] = 0;
    pq.push(Node(start, dist[start]));
    while(!pq.empty()){
        int cur = pq.top().idx;
        int val = pq.top().val;
        pq.pop();
        if(val>dist[cur]) continue;
        int len = v[cur].size();
        for(int i=0; i<len; ++i){
            int next = v[cur][i].to;
            int cost = v[cur][i].cost;
            if(val+cost < dist[next]){
                dist[next] = val+cost;
                pq.push(Node(next,dist[next]));
            }
        }
    }
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n  >> e;
    v = vector<vector<Edge>> (n+1);
    for(int i=0; i<e; ++i){
        int a,b,c;
        cin >> a >> b >> c;
        v[a].push_back(Edge(b,c));
        v[b].push_back(Edge(a,c));
    }
    cin >> x >> y;
    // p1 = 1 x y n
    // p2 = 1 y x n
    
    daijkstra(1);
    int p1 = dist[x];
    int p2 = dist[y];
    daijkstra(x);
    p1 += dist[y];
    p2 += dist[y];
    daijkstra(n);
    p1 += dist[y];
    p2 += dist[x];
    int ans = min(p1, p2);
    if(ans>=INF) cout << -1;
    else cout << ans;
    return 0;
}
