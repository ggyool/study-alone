#include <algorithm>
#include <queue>
#include <iostream>
#include <vector>
using namespace std;

struct Edge
{
	int to, cost;
	Edge(int a, int b)
		: to(a), cost(b) {}
};

struct Node
{
	int idx, val;
	Node(int a, int b)
		: idx(a), val(b) {}
	bool operator<(const Node& ref) const
	{
		return val > ref.val;
	}
};

const int INF = (int)1e9;
int n, m, start;
vector<vector<Edge>> adj;
vector<int> dist;

void daijkstra()
{
	priority_queue<Node> pq;
	dist[start] = 0;
	pq.push(Node(start, 0));
	while (!pq.empty())
	{
		int cur = pq.top().idx;
		int val = pq.top().val;
		pq.pop();
		if (val > dist[cur]) continue;
		int len = adj[cur].size(); 
		for (int i = 0; i < len; ++i)
		{
			int next = adj[cur][i].to;
			int cost = adj[cur][i].cost;
			if (dist[next] > dist[cur] + cost)
			{
				dist[next] = dist[cur] + cost;
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
	int tc;
	cin >> tc;
	while (tc--)
	{
		cin >> n >> m >> start;
		adj = vector<vector<Edge>>(n + 1);
		dist = vector<int>(n + 1, INF);
		for (int i = 0; i < m; ++i)
		{
			int a, b, c;
			cin >> a >> b >> c;
			adj[b].push_back(Edge(a, c));
		}
		daijkstra();
		int cnt = 0;
		int lastTime = 0;
		for (int i = 1; i <= n;++i)
		{
			if (dist[i] != INF)
			{
				++cnt;
				lastTime = max(lastTime, dist[i]);
			}
		}
		cout << cnt << ' ' << lastTime << '\n';
	}

	return 0;
}