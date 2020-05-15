#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

struct Edge
{
	int to, cost;
	Edge(int a, int b)
		: to(a), cost(b) {}
};

const int INF = (int)2e9;
int n, m, sta, fin;
vector<vector<Edge>> adj;
vector<bool> visited;
vector<int> dist;
vector<int> path;

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

int dijkstra()
{
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
	return dist[fin];
}

bool dfs(int cur)
{
	if (cur == fin) return true;
	int len = adj[cur].size();
	for (int i = 0; i < len; ++i)
	{
		int next = adj[cur][i].to;
		int cost = adj[cur][i].cost;
		if (dist[next] == dist[cur] + cost)
		{
			visited[next] = true;
			if (dfs(next))
			{
				path.push_back(next);
				return true;
			}
		}
	}
	return false;
}

int main(void)
{
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	cin >> n >> m;
	adj = vector<vector<Edge>>(n+1);
	visited = vector<bool>(n+1);
	dist = vector<int>(n+1, INF) ;
	for (int i = 0; i < m; ++i)
	{
		int a, b, c;
		cin >> a >> b >> c;
		adj[a].push_back(Edge(b, c));
	}
	cin >> sta >> fin;
	cout << dijkstra() << '\n';
	visited = vector<bool>(n + 1);
	visited[sta] = true;
	dfs(sta);
	path.push_back(sta);
	int plen = path.size();
	cout << plen << '\n';
	for (int i = 0; i < plen; ++i)
	{
		cout << path[plen-1-i] << ' ';
	}
	return 0;
}