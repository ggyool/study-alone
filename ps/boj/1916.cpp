#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;

typedef long long ll;

struct Node{
    int idx;
    ll val;
    Node(int _idx, ll _val) : idx(_idx), val(_val){}
    bool operator<(const Node &ref) const{
        return val > ref.val;
    }
};

struct Edge{
    int to, cost;
    Edge(int _to, int _cost) : to(_to), cost(_cost){}
};

const ll INF = (ll)1e15;
int n,m, sNode, eNode;
vector<vector<Edge>> v;
vector<ll> dist;

ll daijkstra(){
    priority_queue<Node> pq;
    dist[sNode] = 0;
    pq.push(Node(sNode, dist[sNode]));

    while(!pq.empty()){
        int cur = pq.top().idx;
        ll val = pq.top().val;
        pq.pop();
        if(val > dist[cur]) continue;
        int len = v[cur].size();
        for(int i=0; i<len; ++i){
            int next = v[cur][i].to;
            int cost = v[cur][i].cost;
            if(dist[next] > dist[cur] + cost){
                dist[next] = dist[cur] + cost;
                pq.push(Node(next, dist[next]));
            }
        }
    }
    return dist[eNode];
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n >> m;
    v = vector<vector<Edge>> (n+1);
    dist = vector<ll>(n+1, INF);
    for(int i=0; i<m; ++i){
        int a,b,c;
        cin >> a >> b >> c;
        v[a].push_back(Edge(b,c));
    }
    cin >> sNode >> eNode;

    ll res = daijkstra();
    cout << res;
    return 0;
}
