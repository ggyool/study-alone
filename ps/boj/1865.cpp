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
int tc,n,m,w;

// 시작점이 1이면 틀리는 코드
// 문제를 잘 모르겠다.
// 한 지점이라도 - 사이클이 생길 수 있는지를 묻는 문제인 것 같다.
// 1을 시작점으로 잡고 나머 dist에 INF 를 넣으면
// 컴포넌트가 나뉘어 있는 아래 같은 케이스가 문제이다.

/*
1
3 1 1
2 3 1
2 3 2
-----
음수 사이클이므로 Yes 나와야 한다.
*/


bool bellmanFord(){
    for(int k=1; k<=n; ++k){
        for(int i=0; i<2*m+w; ++i){
            int from = v[i].from;
            int to = v[i].to;
            int cost = v[i].cost;
            if(dist[to] > dist[from] + cost){
                dist[to] = dist[from] + cost;
                if(k==n) return false;
            }
        }    
    }
    return true;
}

void init(){
    v.clear();
    dist = vector<ll>(n+1);
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> tc;
    while(tc--){
        cin >> n >> m >> w;
        init();
        for(int i=0; i<m; ++i){
            int a,b,c;
            cin >> a >> b >> c;
            v.push_back(Edge(a,b,c));
            v.push_back(Edge(b,a,c));
        }
        for(int i=0; i<w; ++i){
            int a,b,c;
            cin >> a >> b >> c;
            v.push_back(Edge(a,b,-c));
        }
        if(bellmanFord()) cout << "NO\n";
        else cout << "YES\n";
            
    }
    return 0;
}
