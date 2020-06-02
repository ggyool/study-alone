#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

struct Edge
{
	int to, cost;
	Edge(int a, int b)
		: to(a), cost(b)
	{}
};

const int INF = 2000000000;
int n, m;
int sta, fin;
vector<vector<Edge>> adj;
vector<int> dist;
vector<bool> visited;

int findMinIdx()
{
	int ret = -1;
	// +1 안 넣을 때 런타임 에러
	// 컴포넌트가 여러개인경우 시작점이 없는 컴포넌트들은 모두 INF 이다.
	int val = INF + 1;
	for (int i = 1; i <= n; ++i)
	{
		if (!visited[i] && val > dist[i])
		{
			ret = i;
			val = dist[i];
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
			//if(visited[next]) continue;
			if (dist[next] > dist[cur] + val)
			{
				dist[next] = dist[cur] + val;
			}
		}
	}
	return dist[fin];
}

int main(void)
{
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	cin >> n >> m;
	adj = vector<vector<Edge>>(n + 1);
	dist = vector<int>(n + 1, INF);
	visited = vector<bool>(n + 1);
	for (int i = 0; i < m; ++i)
	{
		int a, b, c;
		cin >> a >> b >> c;
		adj[a].push_back(Edge(b,c));
	}
	cin >> sta >> fin;
	cout << dijkstra();
	return 0;
}
