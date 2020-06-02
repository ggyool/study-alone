#include <iostream>
#include <queue>
#include <algorithm>
#include <vector>
using namespace std;

const int MAX = 32000;
int n, m;
int ind[MAX + 1];
vector<vector<int>> adj;
vector<int> v;

void topoSort()
{
	queue<int> q;
	for (int i = 1; i <= n; ++i)
	{
		if (ind[i] == 0) q.push(i);
	}

	while (!q.empty())
	{
		int cur = q.front();
		q.pop();
		v.push_back(cur);
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
		int a, b;
		cin >> a >> b;
		adj[a].push_back(b);
		++ind[b];
	}
	topoSort();
	int len = v.size();
	for (int i = 0; i < len; ++i)
	{
		cout << v[i] << ' ';
	}
	return 0;
}