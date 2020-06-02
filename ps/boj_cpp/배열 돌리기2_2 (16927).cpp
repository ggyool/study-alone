#include <iostream>
#include <deque>
#include <algorithm>
using namespace std;

int n, m, r;
int arr[300][300];
int ansArr[300][300];

// 동 남 서 북
const int dy[4] = { 0,1,0,-1 };
const int dx[4] = { 1,0,-1,0 };

bool inRange(int y, int x, int b)
{
	if (y<b || y >= n - b || x<b || x >= m - b) return false;
	return true;
}

int main(void)
{
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	cin >> n >> m >> r;
	for (int i = 0; i<n; ++i)
	{
		for (int j = 0; j<m; ++j)
		{
			cin >> arr[i][j];
		}
	}
	int loopn = min(n, m) / 2;
	for (int b = 0; b<loopn; ++b)
	{
		int move = r % (2 * (n - 2 * b) + 2 * (m - 2 * b) - 4);
		int y, x;
		y = x = b;
		int i = 0;
		while (move--)
		{
			if (!inRange(y + dy[i], x + dx[i], b))
			{
				++i;
				++move;
			}
			else
			{
				y += dy[i];
				x += dx[i];
			}
		}
		int sty = y, stx = x;
		int ny = y + dy[i];
		int nx = x + dx[i];
		int insy = b, insx = b;
		ansArr[insy][insx] = arr[sty][stx];
		int j = 3;
		insy += dy[j];
		insx += dx[j];
		
		while (sty != ny || stx != nx)
		{
			bool flag = false;
			
			if (!inRange(ny, nx, b))
			{
				flag = true;
				ny -= dy[i];
				nx -= dx[i];
				i = (i + 1) % 4;
				ny += dy[i];
				nx += dx[i];
			}
			if (!inRange(insy, insx, b))
			{
				flag = true;
				insy -= dy[j];
				insx -= dx[j];
				j = (j + 1) % 4;
				insy += dy[j];
				insx += dx[j];
			}
			if (flag) continue;
			ansArr[insy][insx] = arr[ny][nx];
			insy += dy[j];
			insx += dx[j];
			ny += dy[i];
			nx += dx[i];
		}	
	}

	for (int i = 0; i<n; ++i)
	{
		for (int j = 0; j<m; ++j)
		{
			cout << ansArr[i][j] << ' ';
		}
		cout << '\n';
	}
	return 0;
}