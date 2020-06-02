#include <iostream>
#include <algorithm>
#include <map>
using namespace std;

typedef long long int lld;

/*
sigma f(0~n) = f(n+2) - 1;
*/

const lld MOD = 1e9;
lld a, b;
map<lld, lld> mp;

lld fibo(lld idx)
{
	if (idx < 2) return idx;
	if (mp.count(idx) > 0) return mp[idx];
	mp[idx] = 0;
	if (idx % 2 == 1)
	{
		lld n = (idx + 1) / 2;
		lld na = fibo(n);
		lld nb = fibo(n - 1);
		return mp[idx] = (na*na + nb*nb) % MOD;
	}
	else
	{
		lld n = idx / 2;
		lld na = fibo(n - 1);
		lld nb = fibo(n);
		return mp[idx] = ((2 * na + nb)*nb) % MOD;
	}
}

lld fiboSum(lld idx)
{
	return (fibo(idx + 2)+ MOD - 1)%MOD;
}

int main(void)
{
	cin >> a >> b;
	cout << ((fiboSum(b) - fiboSum(a) + MOD) % MOD + fibo(a))%MOD << '\n';;
	return 0;
}