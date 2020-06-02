#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
using namespace std;

// 최단경로를 조금이라도 포함하면 안되기 때문에 직접 지워야한다.
// 1. dijkstra로 dist 채우기
// 2. reverse 하여 dfs or bfs 하여 path erase 하기 
// reverse 해야한다. 뒤부터 해야지 사전에 cut 할 수 있기 때문에
// 3. 거의 shortDist 구하기

struct Node
{
	int idx, val;
	Node(int x, int y)
		: idx(x), val(y) {}
	bool operator<(const Node& ref) const
	{
		return val > ref.val;
	}
};

struct Edge
{
	int to, cost;
	Edge(int x, int y)
		: to(x), cost(y) {}
};

const int INF = (int)1e8 + 1;
int n, m, start, finish, shortDist;
vector<vector<Edge>> adj;
vector<vector<Edge>> radj;
vector<vector<bool>> isCut;
vector<int> dist;
vector<int> rdist;


int dijkstra()
{
	priority_queue<Node> pq;
	dist[start] = 0;
	pq.push(Node(start, dist[start]));
	while (!pq.empty())
	{
		int cur = pq.top().idx;
		int curDist = pq.top().val;
		pq.pop();
		if (dist[cur] < curDist) continue;
		int len = adj[cur].size();
		for (int i = 0; i < len; ++i)
		{
			int next = adj[cur][i].to;
			if (isCut[cur][next]) continue;
			int cost = adj[cur][i].cost;
			if (dist[next] > dist[cur] + cost)
			{
				dist[next] = dist[cur] + cost;
				pq.push(Node(next, dist[next]));
			}
		}
	}
	return dist[finish];
}

void eraseShortPath()
{
	// 전진한다는 것은 길이 하나라도 있다는 것
	queue<int> q;
	q.push(finish);
	while (!q.empty())
	{
		int cur = q.front();
		q.pop();
		int len = radj[cur].size();
		for (int i = 0; i < len; ++i)
		{
			int next = radj[cur][i].to;
			int cost = radj[cur][i].cost;
			// next + cost = cur
			if (dist[next] + cost == dist[cur] )
			{
				// next -> cur 라고 해야함 
				isCut[next][cur] = true;
				q.push(next);
			}
		}
	}
}

int main(void)
{
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	while (true)
	{
		cin >> n >> m;
		if (n == 0 && m == 0) break;
		adj = vector<vector<Edge>>(n);
		radj = vector<vector<Edge>>(n);
		dist = vector<int>(n, INF);
		rdist = vector<int>(n);
		isCut = vector<vector<bool>>(n, vector<bool>(n, false));
		cin >> start >> finish;
		for (int i = 0; i < m; ++i)
		{
			int a, b, c;
			cin >> a >> b >> c;
			adj[a].push_back(Edge(b, c));
			radj[b].push_back(Edge(a, c));
		}
		shortDist = dijkstra();
		eraseShortPath();
		dist = vector<int>(n, INF);
		shortDist = dijkstra();
		if (shortDist == INF) cout << -1 << '\n';
		else cout << shortDist << '\n';
	}
	return 0;
}