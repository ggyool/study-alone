#include <iostream>
#include <algorithm>
#include <cstring>
#include <string>
#include <vector>
using namespace std;

struct Pos
{
	int y, x;
	Pos(int _y, int _x)
		: y(_y), x(_x)
	{}
};


const int dy[4] = {0,1,0,-1};
const int dx[4] = {1,0,-1,0};
int r, c;
bool arr[10][10];
bool visited[10][10];
bool closed = false;


bool inRange(int y, int x)
{
	if (y < 0 || x < 0 || y >= r || x >= c) return false;
	return true;
}

void dfs(int y, int x)
{
	int cnt = 0;
	for (int i = 0; i < 4; ++i)
	{
		int ny = y + dy[i];
		int nx = x + dx[i];
		if (inRange(ny, nx) && arr[ny][nx] == 0 && visited[ny][nx] == 0)
		{
			visited[ny][nx] = true;
			dfs(ny, nx);
		}
		else if (!inRange(ny, nx) || arr[ny][nx] == 1) ++cnt;
	}
	if (cnt == 3) closed = true;
}

int dfsAll()
{
	int ret = 0;
	for (int i = 0; i < r; ++i)
	{
		for (int j = 0; j < c; ++j)
		{
			
			if (arr[i][j] == 0 && visited[i][j]==false)
			{
				visited[i][j] = true;
				++ret;
				dfs(i, j);
			}
		}
	}
	return ret;
}

int main(void)
{
	string s;
	cin >> r >> c;
	for (int i = 0; i < r; ++i)
	{
		cin >> s;
		for (int j = 0; j < c; ++j)
		{
			if (s[j] == 'X') arr[i][j] = true;
			else arr[i][j] = false;
		}
	}
	int res = dfsAll();
	if (res == 1 && closed==false)
		cout << 0 << '\n';
	else
		cout << 1 << '\n';
	return 0;
}