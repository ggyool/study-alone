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

const int INF = (int)1e8;
int n,m,s;
vector<vector<Edge>> v;
vector<int> dist;

void dijkstra(){
    dist = vector<int> (n+1, INF);
    dist[s] = 0;
    priority_queue<Node> pq;
    pq.push(Node(s, dist[s]));
    while(!pq.empty()){
        int cur = pq.top().idx;
        int val = pq.top().val;
        pq.pop();
        if(dist[cur] < val) continue;
        int len = v[cur].size();
        for(int i=0; i<len; ++i){
            int next = v[cur][i].to;
            int cost = v[cur][i].cost;
            if(dist[cur]+cost < dist[next]){
                dist[next] = dist[cur]+cost;
                pq.push(Node(next, dist[next]));
            }
        }
    }
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);    
    cin >> n >> m >> s;
    v = vector<vector<Edge>> (n+1);
    for(int i=0; i<m; ++i){
        int a,b,c;
        cin >> a >> b >> c;
        v[a].push_back(Edge(b,c));
    }
    dijkstra();
    for(int i=1; i<=n; ++i){
        if(dist[i]>=INF) cout << "INF\n";
        else cout << dist[i] << '\n';
    }
    return 0;
}
