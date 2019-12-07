#include <iostream>
#include <algorithm>
using namespace std;

typedef long long lld;
const lld MOD = 1000000007;
const int MAX = 4000001;
bool prime[MAX];
lld n, k;

lld count(lld num, lld digit)
{
	lld ret = 0;
	while (num)
	{
		ret += num / digit;
		num /= digit;
	}
	return ret;
}

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
		return (power(num, exp - 1) * num) % MOD;
	}
}

int main(void)
{
	cin >> n >> k;
	lld ans = 1;
	for (lld i = 2; i <= n; ++i)
	{
		if (prime[i] == false)
		{
			for (lld j = i * 2; j <= n; j += i)
			{
				prime[j] = true;
			}
			lld exp = count(n, i) - count(k, i) - count(n-k, i);
			ans *= power(i, exp);
			ans %= MOD;
		}
	}
	cout << ans << '\n';
	return 0;
}