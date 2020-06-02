#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

struct Edge{
    int to, val;
    Edge(int _to, int _val) : to(_to), val(_val){}
    bool operator<(const Edge &ref) const{
        return val > ref.val;
    }
};

int n, m;
vector<vector<Edge>> v;

// 아무 정점에서 시작하여 우선순위 큐에 후보군들을 넣는다.
int prim(){
    int ret = 0;
    priority_queue<Edge> pq;
    vector<bool> visited(n+1, false);
    visited[1] = true;
    int len = v[1].size();
    for(int i=0; i<len; ++i){
        pq.push(v[1][i]);
    }
    while(!pq.empty()){
        int next = pq.top().to;
        int val = pq.top().val;
        pq.pop();
        if(!visited[next]){
            visited[next] = true;
            ret += val;
            len = v[next].size();
            for(int i=0; i<len; ++i){
                int target = v[next][i].to;
                if(!visited[target]){
                    pq.push(v[next][i]);
                }
            }
        }
    }
    return ret;
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
        v[b].push_back(Edge(a,c));
    }
    cout << prim();
    return 0;
}
