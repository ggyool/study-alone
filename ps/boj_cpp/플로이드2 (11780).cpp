#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

const int INF = (int)1e8;
int dp[101][101];
int via[101][101];
int n, m;

void tracking(vector<int>& path, int sta, int end)
{
	if (via[sta][end] == sta)
	{
		path.push_back(sta);
		return;
	}
	tracking(path, sta, via[sta][end]);
	tracking(path, via[sta][end], end);
}

int main(void)
{
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	cin >> n >> m;
	for (int i = 1; i <= n; ++i)
	{
		for (int j = 1; j <= n; ++j)
		{
			if (i == j) dp[i][j] = 0;
			else dp[i][j] = INF;
		}
	}
	for (int i = 0; i < m; ++i)
	{
		int a, b, c;
		cin >> a >> b >> c;
		dp[a][b] = min(dp[a][b], c);
		via[a][b] = a;
	}
	for (int k = 1; k <= n; ++k)
	{
		for (int i = 1; i <= n;++i)
		{
			for (int j = 1; j <= n; ++j)
			{
				if (dp[i][j] > dp[i][k] + dp[k][j])
				{
					dp[i][j] = dp[i][k] + dp[k][j];
					via[i][j] = k;
				}
			}
		}
	}
	for (int i = 1; i <= n; ++i)
	{
		for (int j = 1; j <= n; ++j)
		{
			if (dp[i][j] == INF) dp[i][j] = 0;
			cout << dp[i][j] << ' ';
		}
		cout << '\n';
	}
	for (int i = 1; i <= n; ++i)
	{
		for (int j = 1; j <= n; ++j)
		{
			if (dp[i][j] == 0) cout << 0 << '\n';
			else
			{
				vector<int> path;
				tracking(path, i, j);
				path.push_back(j);
				cout << path.size() << ' ';
				for (int p = 0; p < path.size(); ++p)
				{
					cout << path[p] << ' ';
				}
				cout << '\n';
			}
		}
	}
	return 0;
}