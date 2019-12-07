#include <iostream>
#include <algorithm>
#include <queue>
using namespace std;

// Union-Find

int n, m;
bool arr[201][201];
bool isPlan[201];
int p[201];

int find(int x)
{
	if (p[x] == x) return x;
	return p[x] = find(p[x]);
}

void Union(int x, int y)
{
	x = find(x);
	y = find(y);
	p[y] = x;	
}

int main(void)
{
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	cin >> n >> m;
	for (int i = 1; i <= n; ++i)
	{
		for (int j = 1; j <= n; ++j)
		{
			cin >> arr[i][j];
		}
		p[i] = i;
	}
	for (int i = 0; i < m; ++i)
	{
		int a;
		cin >> a;
		isPlan[a] = true;
	}
	for (int i = 1; i < n; ++i)
	{
		for (int j = i+1; j <= n; ++j)
		{
			if (arr[i][j])
			{
				Union(i, j);
			}
		}
	}
	bool ans = true;
	int root = -1;
	for (int i = 1; i <= n; ++i)
	{
		if (isPlan[i])
		{
			if (root == -1) root = find(i);
			else if (root != find(i))
			{
				ans = false;
				break;
			}
		}
	}
	if (ans) cout << "YES";
	else cout << "NO";
	return 0;
}