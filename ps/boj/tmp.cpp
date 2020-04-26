#include <iostream>
#include <algorithm>
#include <cstring>

using namespace std;

int n;
int arr[51];
// idx, 높이 차이 = 큰 탑의 높이
// 같은 idx 에서 똑같은 높이 차이의 작은 탑들과 높은 탑들이 있으면 높은 탑을 선택해야한다.
int dp[51][250001];

int main(void)
{
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cin >> n;
	for (int i = 1; i <= n; ++i)
	{
		cin >> arr[i];
	}
	memset(dp, -1, sizeof(dp));
	dp[1][arr[1]] = arr[1];
	dp[1][0] = 0;
	for (int i = 2; i <= n; ++i)
	{
		for (int j = 0; j <= 250000; ++j)
		{
			if (dp[i - 1][j] != -1)
			{
				int high = dp[i - 1][j];
				int diff = j;
				int low = high - diff;
				int cur = arr[i];
				// 높은 곳에 놓은  경우 
				if(high+cur <= 250000)
					dp[i][diff + cur] = max(dp[i][diff + cur], high + cur);
				// 놓지 않은 경우
				dp[i][diff] = max(dp[i][diff], high);
				// 낮은 곳에 놓는 경우 역전 or no
				if (low + cur > high)
				{
					if (low+cur <= 250000)
						dp[i][low + cur - high] = max(dp[i][low + cur - high], low + cur);
				}
				else
				{
					dp[i][high - (low + cur)] = max(dp[i][high - (low + cur)], high);
				}
			}
		}
	}
	int ans = dp[n][0];
	if (ans == 0) cout << -1;
	else cout << ans;
	return 0;
}