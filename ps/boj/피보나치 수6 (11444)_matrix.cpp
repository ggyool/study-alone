#include <iostream>
#include <algorithm>
#include <vector>
#define MOD 1000000007
using namespace std;

typedef long long int lld;
typedef vector < vector<lld>> mat;
lld n;


mat multiMat(mat &ma, mat &mb)
{
	mat ret(2, vector <lld>(2, 0));
	ret[0][0] = (ma[0][0] * mb[0][0] + ma[0][1] * mb[1][0]) % MOD;
	ret[0][1] = (ma[0][0] * mb[0][1] + ma[0][1] * mb[1][1]) % MOD;
	ret[1][0] = (ma[1][0] * mb[0][0] + ma[1][1] * mb[1][0]) % MOD;
	ret[1][1] = (ma[1][0] * mb[0][1] + ma[1][1] * mb[1][1]) % MOD;
	return ret;
}

mat powerMat(mat &m, const lld exp)
{
	if (exp == 1) return m;
	if (exp % 2 == 0)
	{
		mat tm = powerMat(m, exp / 2);
		return multiMat(tm, tm);
	}
	else
	{
		mat tm = powerMat(m, exp - 1);
		return multiMat(tm, m);
	}
}

int main(void)
{
	cin >> n;
	if (n < 2)
	{
		cout << n;
		return 0;
	}
	mat ma(2, vector < lld> (2));
	ma[0][0] = 1;
	ma[0][1] = 1;
	ma[1][0] = 1;
	ma[1][1] = 0;
	mat res = powerMat(ma, n - 1);
	cout << res[0][0];
	return 0;
}