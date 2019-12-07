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

const int BIG = 987654321;
int n, m;
vector<vector<Edge>> adj;
vector<int> dist;

/*
3 2
2 3 2
3 2 -1
-----------
4 4
1 2 500
2 3 -1
3 4 -1
4 2 -1
*/

bool bellmanFord()
{
	dist[1] = 0;
	// n-1 검사, n번째 체크에서 변화가 생겼으면 음수 사이클
	for (int k = 0; k < n; ++k)
	{
		for (int i = 1; i <= n; ++i)
		{
			int len = adj[i].size();
			for (int j = 0; j < len; ++j)
			{
				int next = adj[i][j].to;
				int val = adj[i][j].cost;
				if (dist[i] == BIG) continue;
				if (dist[next] > dist[i] + val)
				{
					if (k == n - 1) return false;
					dist[next] = dist[i] + val;
				}
			}
		}
	}
	return true;
}

int main(void)
{
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	cin >> n >> m;
	adj = vector<vector<Edge>>(n + 1);
	dist = vector<int>(n + 1, BIG);
	for (int i = 0; i < m; ++i)
	{
		int a, b, c;
		cin >> a >> b >> c;
		adj[a].push_back(Edge(b, c));
	}
	if (bellmanFord() == false)
	{
		cout << -1 << '\n';
		return 0;
	}
	for (int i = 2; i <= n; ++i)
	{
		if (dist[i] == BIG) cout << -1 << '\n';
		else cout << dist[i] << '\n';
	}
	return 0;
}