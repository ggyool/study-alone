#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
using namespace std;

// visited 필요없다.

int n, m;
int ind[1001];
bool conn[1001][1001];
vector<vector<int>> adj;
vector<int> sv;

void topologicalSort()
{
	queue<int> q;
	for (int i = 1; i <= n; ++i)
	{
		if (ind[i] == 0)
		{
			q.push(i);
		}
	}
	while (!q.empty())
	{
		int cur = q.front();
		q.pop();
		sv.push_back(cur);
		int len = adj[cur].size();
		for (int i = 0; i < len; ++i)
		{
			int next = adj[cur][i];
			--ind[next];
			if (ind[next] == 0)
			{
				q.push(next);
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
	adj = vector<vector<int>>(n + 1);
	for (int i = 0; i < m; ++i)
	{
		int from, to;
		int t;
		cin >> t;
		for(int j=0; j<t; ++j)
		{
			if (j == 0) cin >> to;
			else
			{
				from = to;
				cin >> to;
				if (conn[from][to] == false)
				{
					conn[from][to] = true;
					adj[from].push_back(to);
					++ind[to];
				}
			}
		}
	}
	topologicalSort();
	if (sv.size() == n)
	{
		for (int i = 0; i < sv.size(); ++i)
		{
			cout << sv[i] << '\n';
		}
	}
	else
	{
		cout << 0;
	}
	return 0;
}