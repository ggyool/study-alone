#include <iostream>
#include <algorithm>
#include <string.h>
#pragma warning(disable:4996)
using namespace std;

int map[35],mx;

int main()
{
	fill_n(&map[0], 35, 0);
	map[1] = 1;
	map[2] = 2;
	scanf("%d", &mx);
	for (int i = 1; i < mx; i++)
	{
			map[i + 1] += map[i];
			map[i + 2] += map[i]*2;
	}
	// 1. 기본적인 타일문제의 DP를 이용하여 해결한다.

	if (mx == 1)
		printf("%d", 1);
	else if (mx % 2 == 0)
		printf("%d", (map[mx]+map[mx/2+1])/2);
	else
		printf("%d", (map[mx]+map[mx/2])/2 );
	// 2. 중복검사를 진행한다.

	return 0;
}
