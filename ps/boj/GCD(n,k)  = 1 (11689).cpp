#include <iostream>
#include <algorithm>
using namespace std;

typedef long long int lld;
lld n;

int main(void)
{
	cin >> n;
	lld ans = 1;
	for (lld i = 2; i*i <= n; ++i)
	{
		if (n%i == 0)
		{
			lld num = 1;
			while (n%i == 0)
			{
				num *= i; 
				n /= i;
			}
			// 여기서 오버플로우 나서 틀렸다.
			// 1,3,2 순서로 할 때 오버플로우 났다.
			ans *= num; // 1
			ans /= i; // 2
			ans *= (i - 1); // 3
		}
	}
	if (n != 1)
	{
		ans *= n;
		ans /= n;
		ans *= (n - 1);
	}
	cout << ans;
	return 0;
}
