#include <string>
#include <vector>
#include <queue>
#include <algorithm>
#include <cstring>
#include <iostream>
using namespace std;

int n;
const int dy[4] = {0,1,0,-1};
const int dx[4] = {1,0,-1,0};
int dist[100][100][2];
vector<vector<int>> v;

// 0 가로, 1 세로
struct Pos
{
	int y, x, d;
	Pos(int _y,int _x, int _d)
	{
		y = _y, x = _x, d = _d;
	}
};


bool inRange(int y, int x, int d)
{
	if (y < 0 || x < 0 || y >= n || x >= n) return false;
	int ny = y + dy[d];
	int nx = x + dx[d];
	if (ny < 0 || nx < 0 || ny >= n || nx >= n) return false;
	return true;
}

bool isEmpty(int y, int x, int d) 
{
	int ny = y + dy[d];
	int nx = x + dx[d];
	return v[y][x] == 0 && v[ny][nx] == 0;
}

bool isGoal(int y, int x, int d)
{
	if (y == n-1 && x == n-1) return true;
	int ny = y + dy[d];
	int nx = x + dx[d];
	if (ny == n - 1 && nx == n - 1) return true;
	return false;
}

bool chkRangeEmpty(int y, int x)
{
	if (y < 0 || x < 0 || y >= n || x >= n) return false;
	return v[y][x] == 0;
}

bool isUpEmpty(int y, int x)
{
	return chkRangeEmpty(y-1, x) && chkRangeEmpty(y-1, x+1);
}

bool isDownEmpty(int y, int x)
{
	return chkRangeEmpty(y+1, x) && chkRangeEmpty(y+1, x+1);
}

bool isLeftEmpty(int y, int x)
{
	return chkRangeEmpty(y, x - 1) && chkRangeEmpty(y + 1, x - 1);
}

bool isRightEmpty(int y, int x)
{
	return chkRangeEmpty(y, x + 1) && chkRangeEmpty(y + 1, x + 1);
}

int solution(vector<vector<int>> board) {
	n = board.size();
	v = board;
	memset(dist, -1, sizeof(dist));
	queue<Pos> q;
	dist[0][0][0] = 0;
	q.push({ 0, 0, 0 });
	while (!q.empty())
	{
		int cy = q.front().y;
		int cx = q.front().x;
		int cd = q.front().d;
		q.pop();
		if (isGoal(cy, cx, cd)) return dist[cy][cx][cd];
		// 방향 그대로 이동
		for (int i = 0; i < 4; ++i)
		{
			int ny = cy + dy[i];
			int nx = cx + dx[i];
			int nd = cd;
			if (inRange(ny, nx, nd) && isEmpty(ny,nx,nd) && dist[ny][nx][nd] == -1)
			{
				dist[ny][nx][nd] = dist[cy][cx][cd] + 1;
				q.push({ny,nx,nd});
			}
		}
		// 가로 방향인 경우
		if (cd == 0)
		{
			if (isUpEmpty(cy, cx))
			{
				int ny = cy - 1;
				int nx = cx;
				int nd = 1;
				if (dist[ny][nx][nd] == -1)
				{
					dist[ny][nx][nd] = dist[cy][cx][cd] + 1;
					q.push({ ny,nx,nd });
				}
				nx += 1;
				if (dist[ny][nx][nd] == -1)
				{
					dist[ny][nx][nd] = dist[cy][cx][cd] + 1;
					q.push({ ny,nx,nd });
				}
			}
			if (isDownEmpty(cy, cx))
			{
				int ny = cy;
				int nx = cx;
				int nd = 1;
				if (dist[ny][nx][nd] == -1)
				{
					dist[ny][nx][nd] = dist[cy][cx][cd] + 1;
					q.push({ ny,nx,nd });
				}
				nx += 1;
				if (dist[ny][nx][nd] == -1)
				{
					dist[ny][nx][nd] = dist[cy][cx][cd] + 1;
					q.push({ ny,nx,nd });
				}
			}
		}
		else
		{
			if (isLeftEmpty(cy, cx))
			{
				int ny = cy;
				int nx = cx - 1;
				int nd = 0;
				if (dist[ny][nx][nd] == -1)
				{
					dist[ny][nx][nd] = dist[cy][cx][cd] + 1;
					q.push({ ny,nx,nd });
				}
				ny += 1;
				if (dist[ny][nx][nd] == -1)
				{
					dist[ny][nx][nd] = dist[cy][cx][cd] + 1;
					q.push({ ny,nx,nd });
				}
			}
			if (isRightEmpty(cy, cx))
			{
				int ny = cy;
				int nx = cx;
				int nd = 0;
				if (dist[ny][nx][nd] == -1)
				{
					dist[ny][nx][nd] = dist[cy][cx][cd] + 1;
					q.push({ ny,nx,nd });
				}
				ny += 1;
				if (dist[ny][nx][nd] == -1)
				{
					dist[ny][nx][nd] = dist[cy][cx][cd] + 1;
					q.push({ ny,nx,nd });
				}
			}
		}
	}
	return -1;
}

int main(void)
{
	cout << solution(
	{ 
		{ 0, 0, 0, 0, 0 },
		{ 1, 1, 1, 1, 0 },
		{ 0, 0, 1, 1, 0 },
		{ 0, 0, 1, 1, 0 },
		{ 0, 0, 1, 0, 0 } 
	});
}