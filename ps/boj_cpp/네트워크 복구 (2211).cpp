#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>
using namespace std;

struct Node
{
	int idx, val;
	Node(int a, int b)
		:idx(a), val(b) {}
	bool operator<(const Node& ref) const
	{
		return val > ref.val;
	}
};

struct Edge
{
	int to, cost;
	Edge(int a, int b)
		: to(a), cost(b) {}
};

const int INF = (int)1e8;
int n, m;
vector<vector<Edge>> adj;
vector<int> dist;
vector<pair<int, int>> recoverEdge;
vector<int> from;
vector< bool> visited;

void dijkstra()
{
	priority_queue<Node> pq;
	dist[1] = 0;
	pq.push(Node(1, dist[1]));
	while (!pq.empty())
	{
		int cur = pq.top().idx;
		int cdist = pq.top().val;
		pq.pop();
		if (cdist > dist[cur]) continue;
		int len = adj[cur].size();
		for (int i = 0; i < len; ++i)
		{
			int next = adj[cur][i].to;
			if (dist[next] > dist[cur] + adj[cur][i].cost)
			{
				from[next] = cur;
				dist[next] = dist[cur] + adj[cur][i].cost;
				pq.push(Node(next, dist[next]));
			}
		}
	}
}

void dfs(int cur)
{
	int len = adj[cur].size();
	for (int i = 0; i < len; ++i)
	{
		int next = adj[cur][i].to;
		if (visited[next] == false && from[next] == cur)
		{
			visited[next] = true;
			recoverEdge.push_back({cur, next});
			dfs(next);
		}
	}
}

int main(void)
{
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	cin >> n >> m;
	adj = vector<vector<Edge>>(n + 1);
	dist = vector<int>(n + 1, INF);
	from = vector<int>(n + 1);
	visited = vector<bool>(n + 1);
	for (int i = 0; i < m; ++i)
	{
		int a, b, c;
		cin >> a >> b >> c;
		adj[a].push_back(Edge(b, c));
		adj[b].push_back(Edge(a, c));
	}
	dijkstra();
	visited[1] = true;
	dfs(1);
	int len = recoverEdge.size();
	cout << len << '\n';
	for (int i = 0; i < len; ++i)
	{
		cout << recoverEdge[i].first << ' ';
		cout << recoverEdge[i].second << '\n';
	}
	return 0;
}