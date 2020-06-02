#include <iostream>
#include <algorithm>
#include <vector>
#include <cstring>
using namespace std;

int n;
int arr[51][10];  
int inn, score, out;
int base, ans;
vector<int> v = {0};
bool visited[10];

int countOne(int num)
{
	int ret = 0;
	while (num)
	{
		ret += num & 1;
		num >>= 1;
	}
	return ret;
}

//  cur: 현재 타순
void solve(int cur)
{
	if (n == inn && out == 3) return;
	if (out == 3)
	{
		++inn;
		out = 0;
		base = 0;
		solve(cur);
		return;
	}
	int comm = arr[inn][v[cur]];
	switch (comm)
	{
	case 0:
		++out; break;
	case 1:
	case 2:
	case 3:
		score += countOne(base >> (3 - comm));
		base <<= comm;
		base |= 1<<(comm-1);
		base &= 0b111;
		break;
	case 4:
		score += countOne(base);
		score += 1;
		base = 0;
		break;
	}
	solve((cur % 9) + 1);
	return;
}

// 타순 생성
void pick(int pickn)
{
	if (pickn == 9)
	{
		inn = 1, out = 0, score = 0, base = 0;
		solve(1);
		if (ans < score)
		{
			ans = score;
		}
		return;
	}
	else if (pickn == 3)
	{
		v.push_back(1);
		pick(pickn + 1);
		v.pop_back();
		return;
	}
	for (int i = 2; i <= 9; ++i)
	{
		if (visited[i] == false)
		{
			visited[i] = true;
			v.push_back(i);
			pick(pickn + 1);
			visited[i] = false;
			v.pop_back();
		}
	}
}

int main(void)
{
	cin >> n;
	for (int i = 1; i <= n; ++i)
	{
		for (int j = 1; j <= 9; ++j)
		{
			cin >> arr[i][j];
		}
	}
	pick(0);
	cout << ans;
	return 0;
}