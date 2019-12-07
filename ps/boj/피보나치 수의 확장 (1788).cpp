#include <iostream>
#include <algorithm>
#define MOD 1000000000
using namespace std;

typedef long long int lld;

int n;
lld arr[(int)1e6 + 1];

int main(void)
{
	cin >> n;
	arr[1] = 1;
	for (int i = 2; i <= 1e6; ++i)
	{
		arr[i] = (arr[i - 1] + arr[i - 2]) % MOD;
	}
	if (n == 0) cout << 0 << '\n';
	else if (n > 0) cout << 1 << '\n';
	else
	{
		n *= -1;
		if (n % 2 == 0) cout << -1 << '\n';
		else cout << 1 << '\n';
	}
	cout << arr[n];
	return 0;
}