#include <iostream>
#include <queue>
#include <algorithm>
#include <vector>
using namespace std;

const int MAX = 32000;
int n, m;
bool visited[MAX + 1];
vector<vector<int>> adj;
vector<int> v;

void dfs(int cur)
{
	int len = adj[cur].size();
	for (int i = 0; i < len; ++i)
	{
		int next = adj[cur][i];
		if (!visited[next])
		{
			visited[next] = true;
			dfs(next);
		}
	}
	v.push_back(cur);
}

void dfsAll()
{
	for (int i = 1; i <= n; ++i)
	{
		if (!visited[i])
		{
			visited[i] = true;
			dfs(i);
		}
	}
}

int main(void)
{
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	cin >> n >> m;
	adj = vector<vector<int>>(n + 1);
	for (int i = 0; i < m; ++i)
	{
		int a, b;
		cin >> a >> b;
		adj[a].push_back(b);
	}
	dfsAll();
	int len = v.size();
	for (int i = 0; i < len; ++i)
	{
		cout << v[len - 1 - i] << ' ';
	}
	return 0;
}