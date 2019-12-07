#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;

int n;
int buildTime[501];
int finTime[501];
int ind[501];
vector<int> adj[501];

int main(void)
{
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	cin >> n;
	for (int i = 1; i <= n; ++i)
	{
		cin >> buildTime[i];
		int from;
		while(true)
		{
			cin >> from;
			if (from == -1) break;
			adj[from].push_back(i);
			++ind[i];
		}
	}

	queue<int> q;
	for (int i = 1; i <= n; ++i)
	{
		if (ind[i] == 0)
		{
			q.push(i);
			finTime[i] = buildTime[i];
		}
	}
	while (!q.empty())
	{
		int cur = q.front();
		q.pop();
		int len = adj[cur].size();
		for (int i = 0; i < len; ++i)
		{
			int next = adj[cur][i];
			if (finTime[next] < finTime[cur] + buildTime[next])
			{
				finTime[next] = finTime[cur] + buildTime[next];
			}
			--ind[next];
			if (ind[next] == 0)
			{
				q.push(next);
			}
		}
	}
	for (int i = 1; i <= n; ++i)
	{
		cout << finTime[i] << '\n';
	}
	return 0;
}