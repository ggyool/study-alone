#include <iostream>
#include <algorithm>
#define N 1000000
using namespace std;

typedef long long int lld;
lld minv, maxv;
bool chk[N + 1];

int main(void)
{
	cin >> minv >> maxv;
	for (lld i = 2; i*i <= maxv; ++i)
	{
		lld sqn = i*i;
		lld start = minv;
		if(minv%sqn!=0) start += (sqn - minv%sqn);
		for (lld j = start; j <= maxv; j+=sqn)
		{
			chk[j - minv] = true;
		}
	}
	int ans = 0;
	for (int i = 0; i <= maxv - minv; ++i)
	{
		if (chk[i] == false) ++ans;
	}
	cout << ans;
	return 0;
}