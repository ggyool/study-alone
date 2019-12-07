#include <iostream>
#include <queue>
#include <algorithm>
#include <vector>
using namespace std;

/*
모든 노드 대상 daijkstra - 84ms

2번 daijkstra - 0ms
파티장으로 가는: 간선 뒤집어서 x에서 daijkstra
돌아오는: x에서 daijkstra
*/

struct Edge
{
	int to, val;
	Edge(int a, int b)
	{
		to = a, val = b;
	}
};

struct Node
{
	int idx, shortDist;
	Node(int a, int b)
	{
		idx = a, shortDist = b;
	}
	// minHeap
	bool operator<(const Node& ref) const
	{
		return shortDist > ref.shortDist;
	}
};

const int INF = (int)1e8;
int n, m, start;
vector<vector<Edge>> adj;
vector<vector<Edge>> radj;
vector<int> goDist;
vector<int> backDist;
vector<bool> visited;

void daijkstra(vector<vector<Edge>> &v, vector<int>& dist, int sta)
{
	visited = vector<bool>(n + 1, false);
	priority_queue<Node> pq;
	dist[sta] = 0;
	pq.push(Node(sta, dist[sta]));
	while (!pq.empty())
	{
		int cur = pq.top().idx;
		pq.pop();
		if (visited[cur]) continue;
		visited[cur] = true;
		int len = v[cur].size();
		for (int i = 0; i < len; ++i)
		{
			int next = v[cur][i].to;
			if (dist[next] > dist[cur] + v[cur][i].val)
			{
				dist[next] = dist[cur] + v[cur][i].val;
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
	cin >> n >> m >> start;
	adj = vector<vector<Edge>>(n + 1);
	radj = vector<vector<Edge>>(n + 1);
	goDist = vector<int>(n + 1, INF);
	backDist = vector<int>(n + 1, INF);
	
	for (int i = 0; i < m; ++i)
	{
		int a, b, c;
		cin >> a >> b >> c;
		adj[a].push_back(Edge(b,c));
		radj[b].push_back(Edge(a, c));
	}
	daijkstra(radj, goDist, start);
	daijkstra(adj, backDist, start);
	int ans = 0;
	for (int i = 1; i <= n; ++i)
	{
		ans = max(ans, goDist[i] + backDist[i]);
	}
	cout << ans;
	
	return 0;
}