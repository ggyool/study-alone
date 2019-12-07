#include <iostream>
#include <algorithm>
using namespace std;

int fact[11];

int nCr(int n, int c)
{
	return fact[n] / fact[c] / fact[n - c];
}

int main(void)
{
	fact[0] = 1;
	for (int i = 1; i <= 10; ++i)
	{
		fact[i] = fact[i - 1] * i;
	}
	int n, c;
	cin >> n >> c;
	cout << nCr(n, c);
	return 0;
}