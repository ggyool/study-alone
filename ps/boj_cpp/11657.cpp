#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;



struct Edge{
	int from, to, cost;
	Edge(int a, int b, int c){
		from = a, to = b, cost = c;
	}
};

typedef long long ll;
vector<ll> dist;
vector<Edge> v;
const ll BIG = 9876543210;
int n,m;

// 시작지점이 고정되어 있을 때 최단경로 구하는 벨만포드
// x->y 로 가는 최단경로는 최대 N-1 간선을 가진다.
// 무식하게 모든 간선을 대상으로 새로고침 작업을 n-1번 해준다.
// n번째에 새로고침이 생기면 음수사이클이 존재한다는 것이다.
bool bellmanFord(){
	dist = vector<ll>(n+1);
	// 시작 노드는 0, 나머지는 INF
	dist[1] = 0;
	for(int i=2; i<=n; ++i){
		dist[i] = BIG;
	}
	for(int k=1; k<=n; ++k){
		for(int i=0; i<m; ++i){
			int from = v[i].from;
			int to = v[i].to;
			int cost = v[i].cost;
			if(dist[from] == BIG) continue;
			if(dist[to] > dist[from]+cost){
				dist[to] = dist[from] + cost;
				if(k==n) return false;
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
	for(int i=0; i<m; ++i){
		int a,b,c;
		cin >> a >> b >> c;
		v.push_back(Edge(a,b,c));
	}
	
	if(bellmanFord()){
		for(int i=2; i<=n; ++i){
			if(dist[i]==BIG) cout << -1 << '\n';
			else cout << dist[i] << '\n';
		}
	}
	else{
		cout << -1;
	}
    return 0;
}
