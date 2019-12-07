#include <algorithm>
#include <iostream>
#include <stack>
using namespace std;

typedef long long int lld;

lld dp[2000][2000];
lld n, k, m;
stack<int> stkn, stkk;

void mDigit()
{
	lld num = n;
	if (num == 0) stkn.push(0);
	while (num)
	{
		stkn.push((int)(num % m));
		num /= m;
	}
	num = k;
	if (num == 0) stkk.push(0);
	while (num)
	{
		stkk.push((int)(num % m));
		num /= m;
	}
}

int calcAns()
{
	int ret = 1;
	while (stkn.size() > stkk.size())
	{
		stkn.pop();
	}
	while (!stkn.empty())
	{
		int a = stkn.top();
		int b = stkk.top();
		stkn.pop();
		stkk.pop();
		ret *= (int)dp[a][b];
		ret %= m;
	}
	return ret;
}

int main(void)
{
	cin >> n >> k >> m;
	for (int i = 0; i <= 1999; ++i)
	{
		for (int j = 0; j <= i; ++j)
		{
			if (j == 0 || i == j) dp[i][j] = 1;
			else
			{
				dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
				dp[i][j] %= m;
			}
		}
	}
	mDigit();
	cout << calcAns();
	return 0;
}