#include <algorithm>
#include <iostream>
using namespace std;

const int MOD = 10007;

int dp[1001][1001];

int main(void)
{
	int n, k;
	cin >> n >> k;
	// i:n, j:k
	for (int i = 0; i <= 1000; ++i)
	{
		for (int j = 0; j <= i; ++j)
		{
			if (j == 0 || i == j) dp[i][j] = 1;
			else
			{
				dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
				dp[i][j] %= MOD;
			}	
		}
	}
	cout << dp[n][k];
	return 0;
}