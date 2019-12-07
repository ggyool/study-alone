#include <iostream>
#include <algorithm>
#include <map>
using namespace std;

typedef long long int lld;

const lld MOD = 1e9 + 7;
map<lld, lld> mp;

/*
GCD(Fn, Fm) = F_gcd(n,m)
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

lld gcd(lld a, lld b)
{
	if (a == 0) return b;
	return gcd(b%a, a);
}

int main(void)
{
	lld n, m;
	cin >> n >> m;
	cout << fibo(gcd(n, m));
	
	return 0;
}