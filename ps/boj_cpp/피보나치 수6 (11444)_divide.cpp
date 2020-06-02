#include <iostream>
#include <algorithm>
#include <map>
#define MOD 1000000007
using namespace std;

typedef long long int lld;
lld n;
map<lld, int> mp;

/*
F_2n-1 = F_n^2 + F_n-1^2
F_2n = (2F_n-1 + F_n) * F_n
*/

lld fibo(lld idx)
{
	if (idx < 2) return idx;
	if (mp.count(idx) != 0)  return mp[idx];
	mp[idx] = 0;
	if (idx % 2 == 0)
	{
		lld na = fibo(idx / 2 - 1);
		lld nb = fibo(idx / 2);
		return mp[idx] = ((2 * na + nb)*nb) % MOD;
	}
	else
	{
		lld na = fibo((idx + 1) / 2);
		lld nb = fibo((idx + 1) / 2 - 1);
		return mp[idx] = (na*na + nb*nb) % MOD;
	}
}

int main(void)
{	
	cin >> n;
	cout << fibo(n);
	return 0;
}