#include <iostream>
#include <algorithm>
using namespace std;

typedef long long int lld;

// 피보나치는 두 항이 뒤를 결정한다.
// 0 1 이 나왔다면 주기가 반복된다고 생각할 수 있다.

int calcPeriod(int mod)
{
	int ret = 1;
	int n1 = 1;
	int n2 = 1;
	while (true)
	{
		if (n1 % mod == 0 && n2 % mod == 1) break;
		int tmp = (n1 + n2) % mod;
		n1 = n2;
		n2 = tmp;
		++ret;
	}
	return ret;
}

int main(void)
{
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	int tc;
	cin >> tc;
	for (int i = 1; i <= tc; ++i)
	{
		int t, m;
		cin >> t >> m;
		cout << i << ' ' << calcPeriod(m) << '\n';
	}
	return 0;
}