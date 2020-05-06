#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
#include <stack>
using namespace std;

struct Node{
    int idx,val;
    Node(int _idx, int _val){
        idx = _idx;
        val = _val;
    }
    bool operator<(const Node &ref) const{
        return val>ref.val;
    }
};

struct Edge{
    int to, cost;
    Edge(int _to, int _cost){
        to = _to;
        cost = _cost;
    }  
};

const int BIG = 987654321;
int n,m,s,e;
vector<vector<Edge>> v;
vector<int> dist, bef, path;

int daijkstra(){
    priority_queue<Node> pq;
    dist = vector<int>(n+1, BIG);
    bef = vector<int>(n+1);
    dist[s] = 0;
    pq.push(Node(s, dist[s]));

    while(!pq.empty()){
        int cur = pq.top().idx;
        int val = pq.top().val;
        pq.pop();
        if(dist[cur]<val) continue;
        int len = v[cur].size();
        for(int i=0; i<len; ++i){
            int next = v[cur][i].to;
            int cost = v[cur][i].cost;
            if(dist[next] > dist[cur]+cost){
                dist[next] = dist[cur] + cost;
                bef[next] = cur;
                pq.push(Node(next, dist[next]));
            }
        }
    }
    return dist[e];
}

void findPath(){
    stack<int> stk;
    stk.push(e);
    while(true){
        if(stk.top() == s) break;
        stk.push(bef[stk.top()]);
    }
    cout << stk.size() << '\n';
    while(!stk.empty()){
        cout << stk.top() << ' ';
        stk.pop();
    }
}

bool dfs(int cur){
    if(cur==e){
        path.push_back(cur);
        return true;
    }
    int len = v[cur].size();
    for(int i=0; i<len; ++i){
        int next = v[cur][i].to;
        int cost = v[cur][i].cost;
        if(dist[next]==dist[cur]+cost){
            if(dfs(next)){
                path.push_back(cur);
                return true;
            }
        }
    }
    return false;
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n >> m;
    v = vector<vector<Edge>>(n+1);
    for(int i=0; i<m; ++i){
        int a,b,c;
        cin >> a >> b >> c;
        v[a].push_back(Edge(b,c));
    }
    cin >> s >> e;
    cout << daijkstra() << '\n';
    // 방법1
    findPath();
    
    // 방법2
    // dfs(s);
    // cout << path.size() << '\n';
    // int plen = path.size();
    // for(int i=0; i<plen; ++i){
    //     cout << path[plen-i-1] << ' ';
    // }
    return 0;
}
