#include <iostream>
#include <vector>
#include <algorithm>
#define MOD 1000
using namespace std;

typedef long long int lld;

int n;
lld b;

/*
edge case
2 1
1000 1000
1000 1000
--------------------------
0 0
0 0
*/

vector<vector<int>> product(vector<vector<int>>& va, vector<vector<int>>& vb)
{
	vector<vector<int>> ret(n, vector<int>(n, 0));
	for (int i = 0; i < n; ++i)
	{
		for (int j = 0; j < n; ++j)
		{
			for (int k = 0; k < n; ++k)
			{
				ret[i][k] += va[i][j] * vb[j][k];
				ret[i][k] %= MOD;
			}
		}
	}
	return ret;
}

vector<vector<int>> multi(vector<vector<int>> &v, lld b)
{
	if (b == 1) return v;
	if (b % 2 == 0)
	{
		vector<vector<int>> tv = multi(v, b / 2);
		return product(tv, tv);
	}
	else
	{
		vector<vector<int>> tv = multi(v, b - 1);
		return product(tv, v);
	}
}


int main(void)
{
	cin >> n >> b;
	vector<vector<int>> va(n, vector<int>(n, 0));
	for (int i = 0; i < n; ++i)
	{
		for (int j = 0; j < n; ++j)
		{
			cin >> va[i][j];
		}
	}
	vector<vector<int>> ans = multi(va, b);
	for (int i = 0; i < n; ++i)
	{
		for (int j = 0; j < n; ++j)
		{
			cout << ans[i][j] % MOD << ' ';
		}
		cout << '\n';
	}
	return 0;
}