#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

const int BIG = 987654321;
const int dy[4] = {1, 1, -1, -1};
const int dx[4] = {-1, 1, 1, -1};
int arr[22][22];
int n, total;
int lt[22][22];
int rt[22][22];

bool inRange(int y, int x)
{
	if (y<1 || x<1 || y>n || x>n) return false;
	return true;
}

int solve(int y, int x, int d1, int d2)
{
	int ty[4] = {y+d1, y+d1+d2, y+d2, y};
	int tx[4] = {x-d1, x-d1+d2, x+d2, x};
	int sum[5] = {0,0,0,0,0};
	int d = 0;
	int cy = y;
	int cx = x;
	for (int i = y - 1; i >= 1; --i) sum[d] += lt[i][cx];
	while (cy != ty[d] || cx != tx[d])
	{
		sum[d] += lt[cy][cx-1];
		cy += dy[d];
		cx += dx[d];
	}
	++d;
	while (cy != ty[d] || cx != tx[d])
	{
		sum[d] += lt[cy][cx - 1];
		cy += dy[d];
		cx += dx[d];
	}
	for(int i=cy; i<=n; ++i) sum[d] += lt[i][cx-1];
	++d;
	for (int i = cy+1; i <= n; ++i) sum[d] += rt[i][cx];
	while (cy != ty[d] || cx != tx[d])
	{
		sum[d] += rt[cy][cx + 1];
		cy += dy[d];
		cx += dx[d];
	}
	++d;
	while (cy != ty[d] || cx != tx[d])
	{
		sum[d] += rt[cy][cx + 1];
		cy += dy[d];
		cx += dx[d];
	}
	for(int i=cy; i>=1; --i) sum[d] += rt[i][cx+1];
	sum[4] = total - sum[0] - sum[1] - sum[2] - sum[3];
	int maxv = 0;
	int minv = BIG;
	for (int i = 0; i < 5; ++i)
	{
		maxv = max(maxv, sum[i]);
		minv = min(minv, sum[i]);
	}
	return maxv - minv;
}	

int main(void)
{
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	cin >> n;
	for (int i = 1; i <= n; ++i)
	{
		for (int j = 1; j <= n; ++j)
		{
			cin >> arr[i][j];
			total += arr[i][j];
		}
	}
	for (int i = 1; i <= n; ++i)
	{
		for (int j = 1; j <= n; ++j)
		{
			lt[i][j] = lt[i][j - 1] + arr[i][j];
			rt[i][n + 1 - j] = rt[i][n + 1 - j +1] + arr[i][n + 1 - j];
		}
	}
	int ans = BIG;
	for (int i = 1; i <= n - 2; ++i)
	{
		for (int j = 1; j <= n - 1; ++j)
		{
			for (int d1 = 1; j - d1 > 0;++d1)
			{
				for (int d2 = 1; j + d2 <= n;++d2)
				{
					if (!inRange(i + d1 + d2, j - d1 + d2)) continue;
					ans = min(ans, solve(i, j, d1, d2));
				}
			}
		}
	}
	cout << ans;
	return 0;
}