#include <iostream>
#include <algorithm>
#include <vector>
#include <cmath>
#define N 1000000
using namespace std;

typedef long long int lld;

lld A, B;
vector<lld> sv;
lld svlen;
bool notPrime[(int)1e6 + 1];
//false 이면 제곱ㄴㄴ수
bool notSqn[(int)1e6 + 1];

bool inRange(lld num)
{
	if (num<A || num>B) return false;
	return true;
}

int main(void)
{
	// 1~100만까지 소수
	for (lld i = 2; i*i <= N;++i)
	{
		if (notPrime[i]) continue;
		for (lld j = 2 * i; j <= N; j+=i)
		{
			notPrime[j] = true;
		}
	}
	for (lld i = 2; i <= N; ++i)
	{
		if (notPrime[i] == false)
			sv.push_back(i*i);
	}
	svlen = sv.size(); // 78498
	cin >> A >> B;
	for (int i = 0; i < svlen; ++i)
	{
		lld sqn = sv[i];
		if (sqn > B) continue;
		lld div = A / sqn;	
		if (A%sqn != 0) ++div;
		for(lld j=div*sqn; j<=B; j+=sqn)
		{
			notSqn[j-A] = true;
		}
	}
	int ans = 0;
	for (int i = 0; i <= B-A; ++i)
	{
		if (notSqn[i] == false)
			++ans;
	}
	cout << ans;
	return 0;
}