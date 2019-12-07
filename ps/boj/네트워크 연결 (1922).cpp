#include <iostream>
#include <algorithm>
#include <queue>
#include <vector>
using namespace std;

int n, m;

struct Edge
{
	int to, cost;
	Edge(int a, int b)
	{
		to = a;
		cost = b;
	}
	bool operator<(const Edge &ref) const
	{
		// minHeap
		return cost > ref.cost;
	}
};

vector<vector<Edge>> adj;
vector<bool> visited;

int mstPrim()
{
	int ret = 0;
	int start = 1;
	priority_queue<Edge> pq;
	visited[start] = true;
	for (int i = 0; i < adj[start].size(); ++i)
	{
		pq.push(adj[start][i]);
	}
	while (!pq.empty())
	{
		int next = pq.top().to;
		int val = pq.top().cost;
		pq.pop();
		if (visited[next] == false)
		{
			ret += val;
			visited[next] = true;
			for (int i = 0; i < adj[next].size(); ++i)
			{
				if (visited[adj[next][i].to] == false)
				{
					pq.push(Edge(adj[next][i]));
				}
			}
		}
	}
	return ret;
}

int main(void)
{
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	cin >> n >> m;
	adj = vector<vector<Edge>>(n + 1);
	visited = vector<bool>(n + 1);
	for (int i = 0; i < m; ++i)
	{
		int from, to, val;
		cin >> from >> to >> val;
		adj[from].push_back(Edge(to, val));
		adj[to].push_back(Edge(from, val));
	}
	cout << mstPrim();
	return 0;
}