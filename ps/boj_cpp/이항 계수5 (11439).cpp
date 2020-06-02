#include <iostream>
#include <algorithm>
using namespace std;

typedef long long int lld;

lld n, k, m;
const int MAX = 4000001;
bool isPrime[MAX]; // prime: false
lld cntN[MAX];
lld cntK[MAX];
lld cntN_K[MAX];

/*
idea: 소인수 분해를 이용
1. 필요한 숫자까지 소수를 구한다.
2. n! / k! / n-k! 각각 소수들이 몇 제곱인지 센다.
*/

lld power(lld num, lld exp)
{
	if (exp == 0) return 1;
	if (exp % 2 == 0)
	{
		lld tmp = power(num, exp / 2);
		return (tmp*tmp) % m;
	}
	else
	{
		return (power(num, exp - 1) * num) % m;
	}
}

int main(void)
{
	cin >> n >> k >> m;
	for (int i = 2; i*i <= n; ++i)
	{
		if (isPrime[i] == false)
		{
			for (int j = 2 * i; j <= n; j += i)
			{
				isPrime[j] = true;
			}
		}
	}
	lld ans = 1;
	for (int i = 2; i <= n; ++i)
	{
		if (!isPrime[i])
		{
			// overflow 간신히 찾았다. 
			for (lld j = i; j <= n; j *= i)
			{
				cntN[i] += n / j;
				if(j<=k) cntK[i] += k / j;
				if (j <= n - k) cntN_K[i] += (n-k) / j;
			}
			lld exp = cntN[i] - cntK[i] - cntN_K[i];
			if (exp > 0)
			{
				ans *= power(i, exp);
				ans %= m;
			}
		}
	}
	cout << ans;
	return 0;
}
