#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
using namespace std;

struct Edge
{
	int to, cost;
	Edge(int x, int y)
		: to(x), cost(y) {}
	bool operator<(const Edge &ref) const
	{
		return cost > ref.cost;
	}
};

int n, m, total;
vector<vector<Edge>> adj;
vector<bool> visited;

// 연결한 간선합을 return한다.
int mstPrim()
{
	int ret = 0;
	int start = 0;
	priority_queue<Edge> pq;
	visited[start] = true;
	int len = adj[start].size();
	for (int i = 0; i < len; ++i)
	{
		pq.push(adj[start][i]);
	}
	while (!pq.empty())
	{
		int cur = pq.top().to;
		int cost = pq.top().cost;
		pq.pop();
		if (visited[cur]) continue;

		visited[cur] = true;
		ret += cost;
		
		len = adj[cur].size();
		for (int i = 0; i < len; ++i)
		{
			int next = adj[cur][i].to;
			if (!visited[next]) pq.push(adj[cur][i]);
		}
	}
	return ret;
}

int main(void) 
{
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	while (true)
	{
		cin >> n >> m;
		if (n == 0) break;
		adj = vector<vector<Edge>>(n);
		visited = vector<bool>(n, false);
		total = 0;
		for (int i = 0; i < m; ++i)
		{
			int x, y, z;
			cin >> x >> y >> z;
			adj[x].push_back(Edge(y, z));
			adj[y].push_back(Edge(x, z));
			total += z;
		}
		cout << total - mstPrim() << '\n';
	}
	return 0;
}