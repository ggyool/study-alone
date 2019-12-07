#include <iostream>
using namespace std;

typedef long long int lld;

lld n;

int main(void)
{
	cin >> n;
	lld ans = n;
	for (lld i = 2; i*i <= n; ++i)
	{
		if (n%i == 0)
		{
			while (n%i == 0)
			{
				n /= i;
			}
			ans -= ans / i;
		}
	}
	if (n != 1) ans -= ans / n;
	cout << ans;
	return 0;
}