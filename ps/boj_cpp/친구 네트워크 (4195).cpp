#include <algorithm>
#include <iostream>
#include <unordered_map>
#include <string>
#include <vector>
using namespace std;

// unoredered_map 으로 바꾸니 76->40
unordered_map<string, int> numbering;
int n, idx;
int groupCnt[(int)2e5 + 1];
int p[(int)2e5 + 1];

int find(int x)
{
	if (p[x] == x) return x;
	return p[x] = find(p[x]);
}

void Union(int x, int y)
{
	y = find(y);
	x = find(x);
	if (y == x) return;
	groupCnt[x] += groupCnt[y];
	groupCnt[y] = 0;
	p[y] = x;
}

int main(void)
{
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	int tc;
	string x, y;
	cin >> tc;
	while (tc--)
	{
		idx = 0;
		cin >> n;
		for (int i = 1; i <= 2 * n; ++i)
		{
			groupCnt[i] = 1;
			p[i] = i;
		}
		for (int i = 1; i <= n; ++i)
		{
			int px, py;
			cin >> x >> y;
			px = numbering[x];
			py = numbering[y];
			if (px == 0)
			{
				numbering[x] = ++idx;
				px = idx;
			}
			if (py == 0)
			{
				numbering[y] = ++idx;
				py = idx;
			}
			if (px == idx)
			{
				Union(py, px);
				cout << groupCnt[find(py)] << '\n';
			}
			else
			{
				Union(px, py);
				cout << groupCnt[find(px)] << '\n';
			}
		}
	}
	return 0;
}