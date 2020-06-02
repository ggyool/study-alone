#include <iostream>
#include <vector>
#include <deque>
#define W 0
#define R 1
#define B 2

using namespace std;

const int dy[5] = { 0,0,0,-1,1 };
const int dx[5] = { 0,1,-1,0,0 };
int hy[11];
int hx[11];
int hd[11];
int n, m;
int arr[13][13];
vector<vector<deque<int>>> v;

bool inRange(int y, int x)
{
	if (y<1 || x<1 || y>n || x>n) return false;
	return true;
}

bool move(int cy, int cx, int ny, int nx)
{
	while (!v[cy][cx].empty())
	{
		int idx = v[cy][cx].front();
		v[cy][cx].pop_front();
		hy[idx] = ny;
		hx[idx] = nx;
		v[ny][nx].push_back(idx);
	}
	if (v[ny][nx].size() >= 4) return true;
	return false;
}

bool rmove(int cy, int cx, int ny, int nx)
{
	while (!v[cy][cx].empty())
	{
		int idx = v[cy][cx].back();
		v[cy][cx].pop_back();
		hy[idx] = ny;
		hx[idx] = nx;
		v[ny][nx].push_back(idx);
	}
	if (v[ny][nx].size() >= 4) return true;
	return false;
}

int main(void)
{
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cin >> n >> m;
	v = vector<vector<deque<int>>> (n+1, vector<deque<int>>(n+1));
	for (int i = 1; i <= n; ++i)
	{
		for(int j = 1; j <= n; ++j)
		{
			cin >> arr[i][j];
		}
	}
	for (int i = 1; i <= m; ++i)
	{
		cin >> hy[i] >> hx[i] >> hd[i];
		v[hy[i]][hx[i]].push_back(i);
	}
	int turn = 1;
	while (true)
	{
		if (turn > 1000) break;
		for (int i = 1; i <= m; ++i)
		{
			int cy = hy[i];
			int cx = hx[i];
			int cd = hd[i];
			if (i != v[cy][cx].front()) continue;
			int ny = cy + dy[cd];
			int nx = cx + dx[cd];
			if(!inRange(ny,nx) || arr[ny][nx] == B)
			{
				if (cd % 2 == 0) --cd, --hd[i];
				else ++cd, ++hd[i];
				ny = cy + dy[cd];
				nx = cx + dx[cd];
				if (!inRange(ny, nx) || arr[ny][nx] == B);
				else if (arr[ny][nx] == W)
				{
					if (move(cy, cx, ny, nx))
					{
						cout << turn;
						return 0;
					}
				}
				else
				{
					if (rmove(cy, cx, ny, nx))
					{
						cout << turn;
						return 0;
					}
				}
			}
			else if (arr[ny][nx] == W)
			{
				if (move(cy, cx, ny, nx))
				{
					cout << turn;
					return 0;
				}
			}
			else
			{
				if (rmove(cy, cx, ny, nx))
				{
					cout << turn;
					return 0;
				}
			}
		}
		++turn;
	}
	cout << -1;
	return 0;
}