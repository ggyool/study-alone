#include <algorithm>
#include <vector>
#include <iostream>
using namespace std;

struct Edge
{
	int to, cost;
	Edge(int a, int b)
		:to(a), cost(b) {}
};

const int INF = 800000 + 1;
int n, m, via1, via2;;
vector<vector<Edge>> adj;
vector<bool> visited;
vector<int> dist;

int findMinIdx()
{
	int ret = -1;
	int val = INF + 1;
	for (int i = 1; i <= n; ++i)
	{
		if (!visited[i] && val > dist[i])
		{
			val = dist[i];
			ret = i;
		}
	}
	return ret;
}

void dijkstra(int sta)
{
	visited = vector<bool>(n + 1);
	dist = vector<int>(n + 1, INF);
	dist[sta] = 0;
	for (int i = 0; i < n - 1; ++i)
	{
		int cur = findMinIdx();
		visited[cur] = true;
		int len = adj[cur].size();
		for (int j = 0; j < len; ++j)
		{
			int next = adj[cur][j].to;
			int val = adj[cur][j].cost;
			if (dist[next] > dist[cur] + val)
			{
				dist[next] = dist[cur] + val;
			}
		}
	}
}

int main(void)
{
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	cin >> n >> m;
	adj = vector<vector<Edge>>(n+1);
	for (int i = 0; i < m; ++i)
	{
		int a, b, c;
		cin >> a >> b >> c;
		adj[a].push_back(Edge(b, c));
		adj[b].push_back(Edge(a, c));
	}
	cin >> via1 >> via2;
	// p1: 1->v1->v2->n
	// p2: 1->v2->v1->n
	int p1 = 0, p2 = 0;
	dijkstra(1);
	p1 += dist[via1];
	p2 += dist[via2];
	dijkstra(via1);
	p1 += dist[via2];
	p2 += dist[n];
	dijkstra(via2);
	p1 += dist[n];
	p2 += dist[via1];
	if (p1 >= INF && p2 >= INF) cout << -1;
	else cout << min(p1, p2);
	return 0;
}