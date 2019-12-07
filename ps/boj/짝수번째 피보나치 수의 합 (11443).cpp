#include <iostream>
#include <algorithm>
#include <map>
using namespace std;

typedef long long int lld;

const lld MOD = 1e9 + 7;
map<lld, lld> mp;

/*
sigma f(0~2n) = f(2n+1) - 1
*/

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

int main(void)
{
	lld n;
	cin >> n;
	if(n%2==0) cout << (fibo(n + 1) + MOD - 1) % MOD;
	else cout << (fibo(n) + MOD - 1) % MOD;
	return 0;
}