#include <iostream>
#include <cstring>
#include <algorithm>
using namespace std;


int r, c;
int arr[501][501];
int dp[501][501];
const int dy[4] = { 0,1,0,-1 };
const int dx[4] = { 1,0,-1,0 };

bool inRange(int y, int x)
{
	if (y <= 0 || x <= 0 || y > r || x > c) return false;
	return true;
}

int topDown(int y, int x)
{
	if (y == 1 && x == 1) return 1;
	int &ret = dp[y][x];
	if (ret != -1) return ret;
	ret = 0;
	for (int i = 0; i < 4; ++i)
	{
		int ny = y + dy[i];
		int nx = x + dx[i];
		if (inRange(ny, nx) && arr[ny][nx] > arr[y][x] )
		{
			ret += topDown(ny, nx);
		}
	}
	return ret;
}

int main(void)
{
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	cin >> r >> c;
	memset(dp, -1, sizeof(dp));
	for (int i = 1; i <= r; ++i)
	{
		for (int j = 1; j <= c; ++j)
		{
			cin >> arr[i][j];
		}
	}

	cout << topDown(r, c);

	return 0;
}
