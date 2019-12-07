#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;

struct Edge
{
	int to, cost;
	Edge(int a, int b)
		:to(a), cost(b) {}
};

struct Node
{
	int idx, shortDist;
	Node(int a, int b)
		: idx(a), shortDist(b) {}
	// minHeap
	bool operator<(const Node &ref) const
	{
		return shortDist > ref.shortDist;
	}
};

const int INF = (int)1e8;
int n, m, sta;
vector<vector<Edge>> adj;
vector<int> dist;
vector<bool> visited;
priority_queue<Node> pq;

void daijkstra()
{
	dist[sta] = 0;
	pq.push(Node(sta, dist[sta]));
	while (!pq.empty())
	{
		int cur = pq.top().idx;
		pq.pop();
		// 같은 노드가 갱신 되어 여러번 pq에 들어갈 수 있음
		// 헛돌기는 하지만 cotinue 빼도 pass
		if (visited[cur]) continue;
		visited[cur] = true;
		int len = adj[cur].size();
		for (int i = 0; i < len; ++i)
		{
			int next = adj[cur][i].to;
			if (dist[next] > dist[cur] + adj[cur][i].cost)
			{
				dist[next] = dist[cur] + adj[cur][i].cost;
				pq.push(Node(next, dist[next]));
			}
		}
	}
}

int main(void)
{
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	cin >> n >> m >> sta;
	adj = vector<vector<Edge>>(n+1);
	dist = vector<int>(n + 1, INF);
	visited = vector<bool>(n + 1);
	for (int i = 0; i < m; ++i)
	{
		int a, b, c;
		cin >> a >> b >> c;
		adj[a].push_back(Edge(b, c));
	}
	daijkstra();
	for (int i = 1; i <= n; ++i)
	{
		if (dist[i] >= INF) cout << "INF\n";
		else cout << dist[i] << '\n';
	}
	return 0;
}