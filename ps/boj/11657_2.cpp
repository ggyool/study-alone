// spfa
#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;

struct Edge{
	int to, cost;
	Edge(int a, int b){
		to = a, cost = b;
	}
};

typedef long long ll;
const ll INF = (ll)1e11;
int n,m;
ll dist[501];
bool visited[501];
int cnt[501];
vector<vector<Edge>> v;

bool spfa(){
    dist[1] = 0;
    ++cnt[1];
    visited[1] = true;
    for(int i=2; i<=n; ++i) dist[i] = INF;
    queue<int> q;
    q.push(1);
    while(!q.empty()){
        int cur = q.front();
        q.pop();
        visited[cur] = false;
        int len = v[cur].size();
        for(int i=0; i<len; ++i){
            int next = v[cur][i].to;
            int cost = v[cur][i].cost;
            if(dist[cur] + cost < dist[next]){
                dist[next] = dist[cur] + cost;
                // visited 체크를 안하면
                // n번이 cycle 이라고 판단할 수 없을듯
                // 한 턴에 서로 다른 경로로 와서 갱신 여러번 할듯?
                if(!visited[next]){
                    ++cnt[next];
                    visited[next] = true;
                    if(cnt[next]>=n) return false;
                    q.push(next);
                }
            }
        }
    }
    return true;
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n >> m;
    v = vector<vector<Edge>> (n+1);
    for(int i=0; i<m; ++i){
        int a,b,c;
        cin >> a >> b >> c;
        v[a].push_back(Edge(b,c));
    }

    if(spfa()){
        for(int i=2; i<=n; ++i){
            if(dist[i]==INF) cout << -1 << '\n';
            else cout << dist[i] << '\n';
        }
    }
    else{
        cout << -1;
    }
    return 0;
}
