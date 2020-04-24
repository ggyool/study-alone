#include <iostream>
#include <algorithm>
#include <string>
#include <cstring>
using namespace std;

typedef long long int lld;

const int MOD = 1000000;
string s;
int n;
const string opens = "([{";
const string closes = ")]}";
lld dp[201][201];

/*
50
([[[???[]?[??][??]?{??({})]??{[]}?{?????}(?()???{?
*/
lld solve(int left, int right)
{
	if (left > right) return 1;

	lld& ret = dp[left][right];
	if (ret != -1) return ret;
	ret = 0;
	for (int i = left + 1; i <= right; i+=2)
	{
		for (int j = 0; j < 3; ++j)
		{
			if (s[left] == opens[j] || s[left] == '?')
			{
				if (s[i] == closes[j] || s[i] == '?')
				{
					ret += solve(left + 1, i - 1) * solve(i + 1, right);
					//ret %= MOD;
				}
			}
		}
	}
	return ret;
}

int main(void)
{
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cin >> n >> s;
	memset(dp, -1, sizeof(dp));
	lld ans = solve(0, n - 1);
	cout << ans;
	return 0;
	if (ans < MOD/10) cout << ans;
	else
	{
		for (int i = 100000; i >= 10; i/=10)
		{
			cout << (ans % i) / (i/10);
		}
	}
	return 0;
}