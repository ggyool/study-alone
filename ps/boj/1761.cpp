#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;

struct Edge{
    int to, cost;
    Edge(int _to, int _cost) : to(_to), cost(_cost) {}
};

int n,m;
vector<vector<Edge>> v;
vector<int> depth;
vector<int> p;
// 부모노드에서 해당 노드까지의 거리
vector<int> cost;
vector<int> dist;

// 1. lca 구하면서 답 구하기
int lcaDist(int a,int b){
    int ans = 0;
    while(a!=b){
        if(depth[a] < depth[b]){
            ans += cost[b];
            b = p[b];
        }
        else if(depth[a] > depth[b]){
            ans += cost[a];
            a = p[a];
        }
        else{
            ans += cost[a];
            ans += cost[b];
            a = p[a];
            b = p[b];
        }
    }
    return ans;
}

// 2. root에서 거리 미리 구해놓고, dist[a] + dist[b] - 2*dist[lca];
int lca(int a, int b){
    while(a!=b){
        if(depth[a] < depth[b]){
            b = p[b];
        }
        else if(depth[a] > depth[b]){
            a = p[a];
        }
        else{
            a = p[a];
            b = p[b];
        }
    }
    return a;
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n;
    v = vector<vector<Edge>> (n+1);
    depth = vector<int> (n+1, -1);
    p = vector<int> (n+1, -1);
    cost = vector<int> (n+1, 0);
    dist = vector<int> (n+1, 0);
    for(int i=0; i<n-1; ++i){
        int a,b,c;
        cin >> a >> b >> c;
        v[a].push_back(Edge(b,c));
        v[b].push_back(Edge(a,c));
    }
    // root 노드는 상관없다.
    queue<int> q;
    depth[1] = 1;
    p[1] = 1;
    q.push(1);
    while(!q.empty()){
        int cur = q.front();
        q.pop();
        int len = v[cur].size();
        for(int i=0; i<len; ++i){
            int next = v[cur][i].to;
            if(depth[next] == -1){
                depth[next] = depth[cur] + 1;
                p[next] = cur;
                cost[next] = v[cur][i].cost;
                dist[next] += dist[cur] + v[cur][i].cost;
                q.push(next);
            }
        }
    }
    cin >> m;
    for(int i=0; i<m; ++i){
        int a,b;
        cin >> a >> b;
        // cout << lcaDist(a,b) << '\n';
        cout << dist[a] + dist[b] - 2*dist[lca(a,b)] << '\n';
    }
    return 0;
}
