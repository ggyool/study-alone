#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int n, m;
const int INF = (int)1e8;
int dp[101][101];

// 예전에 bfs로 풀었던 문제 플로이드로 풀어봄
// INF로 초기화 할 수도 있지만, 코드가 늘어나므로 if로 해결
int main(void)
{
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	cin >> n >> m;
	for (int i = 1; i <= m; ++i)
	{
		int a, b;
		cin >> a >> b;
		dp[a][b] = 1;
		dp[b][a] = 1;
	}
	for (int k = 1; k <= n; ++k)
	{
		for (int i = 1; i <= n; ++i)
		{
			for (int j = 1; j <= n; ++j)
			{
				if (dp[i][k] != 0 && dp[k][j] != 0)
				{
					if(dp[i][j]==0 && i!= j) dp[i][j] = dp[i][k] + dp[k][j];
					else dp[i][j] = min(dp[i][j], dp[i][k] + dp[k][j]); // i==j 0이라 실행해도 됨
				}
			}
		}
	}
	int minV = INF;
	int idx = 0;
	for (int i = 1; i <= n; ++i)
	{
		int sum = 0;
		for (int j = 1; j <= n; ++j)
		{
			sum += dp[i][j];
		}
		if (minV > sum)
		{
			idx = i;
			minV = sum;
		}
	}
	cout << idx;
	return 0;
}