#include <iostream>
#include <queue>
#include <vector>
#include <functional>
using namespace std;


priority_queue<int, vector<int>, greater<int>> pq;

int n, m;
vector<vector<int>> adj;
vector<int> ind;

void topoSort()
{
	for (int i = 1; i <= n; ++i)
	{
		if (ind[i] == 0) pq.push(i);
	}
	while (!pq.empty())
	{
		int cur = pq.top();
		pq.pop();
		cout << cur << ' ';
		int len = adj[cur].size();
		for (int i = 0; i < len; ++i)
		{
			int next = adj[cur][i];
			--ind[next];
			if (ind[next] == 0) pq.push(next);
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
	ind = vector<int>(n + 1);
	for (int i = 0; i < m; ++i)
	{
		int a, b;
		cin >> a >> b;
		adj[a].push_back(b);
		++ind[b];
	}
	topoSort();
	return 0;
}