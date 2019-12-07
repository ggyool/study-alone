#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>
using namespace std;

int n, m;

vector<vector<int>> adj;
vector<int> useTime;
vector<int> ind;
vector<int> doneTime;

int solve()
{
	int ret = 0;
	queue<int> q;
	for (int i = 1; i <= n; ++i)
	{
		if (ind[i] == 0) 
		{
			q.push(i);
			doneTime[i] = useTime[i];
			ret = max(ret, doneTime[i]);
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
			--ind[next];
			if (doneTime[next] < doneTime[cur] + useTime[next])
			{
				doneTime[next] = doneTime[cur] + useTime[next];
				ret = max(ret, doneTime[next]);
			}
			if (ind[next] == 0)
			{
				q.push(next);
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
	cin >> n;
	adj = vector<vector<int>>(n + 1);
	useTime = vector<int>(n + 1);
	ind = vector<int>(n + 1);
	doneTime = vector<int>(n + 1);
	for (int i = 1; i <= n; ++i)
	{
		cin >> useTime[i];
		cin >> m;
		for (int j = 0; j < m;++j)
		{
			int from;
			cin >> from;
			adj[from].push_back(i);
			++ind[i];
		}
	}
	cout << solve();
	return 0;
}