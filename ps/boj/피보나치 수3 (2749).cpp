#include <iostream>
#include <algorithm>
#define MOD 1000000
#define PERIOD 1500000
using namespace std;

typedef unsigned long long int ulld;

ulld n;
ulld dp[PERIOD + 1];

int main(void)
{
	cin >> n;
	dp[1] = 1;
	for (int i = 2; i <= PERIOD; ++i)
	{
		dp[i] = dp[i - 1] + dp[i - 2];
		dp[i] %= MOD;
	}
	cout << dp[n%PERIOD];

	/* 피사노 주기 구하기
	for (int i = 0; i <= 10000000; ++i)
	{
		if (dp[i-1] == 0 && dp[i]==1) cout << i << '\n';;
	}
	*/
	return 0;
}