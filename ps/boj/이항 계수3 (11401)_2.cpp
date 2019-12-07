#include <iostream>
using namespace std;

typedef long long lld;

const lld MOD = 1000000007;

lld n, k;

lld power(lld num, lld exp)
{
	if (exp == 0) return 1;
	if (exp % 2 == 0)
	{
		lld tmp = power(num, exp / 2);
		return (tmp*tmp) % MOD;
	}
	else
	{
		return  (power(num, exp - 1) * num) % MOD;
	}
}

int main(void)
{
	cin >> n >> k;

	lld ans = 1;
	for (int i = k+1; i <= n; ++i)
	{
		ans *= i;
		ans %= MOD;
	}
	lld num = 1;
	for (int i = 2; i <= n-k; ++i)
	{
		num *= i;
		num %= MOD;
	}
	ans *= power(num, MOD - 2);
	ans %= MOD;
	cout << ans;
	return 0;
}