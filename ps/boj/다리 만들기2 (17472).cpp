#include <iostream>
#include <cstring>
#include <queue>
using namespace std;

/*
1. dfs로 land 번호 numbering
2. bfs로 conn[i][j] 구하기 (i->j 가중치 배열)
3. fdfs로 모든 가능한 경우의 수를 찾는다.
- 1번땅부터 시작, v라는 vector에 하나씩 섬을 추가하며 덩어리를 키워나간다.
- 섬이 추가될 수록 모든 섬에 연결되어있는 경로를 탐색하기 때문에 오래걸린다
- n이 6이라 가능한 풀이 (원래 mst 문제)
*/


// 구역을 나누고 간선을 연결한다.
int r, c;
int arr[10][10];
int area[10][10];
int areaCnt;
int dist[10][10][4];	
int conn[11][11];
bool visited[11];
const int BIG = 987654321;

// 동 남 서 북
const int dy[4] = {0,1,0,-1};
const int dx[4] = {1,0,-1,0};

struct Pos
{
	int y, x, d;
	Pos(int _y = 0, int _x = 0, int _d = 0)
	{
		y = _y, x = _x, d = _d;
	}
};

bool inRange(int y, int x)
{
	if (y < 0 || x < 0 || y >= r || x >= c) return false;
	return true;
}

// start번의 area 시작하는 edge를 구한다.
void bfs(int start)
{
	memset(dist, -1, sizeof(dist));
	queue<Pos> q;
	for (int i = 0; i < r; ++i)
	{
		for (int j = 0; j < c; ++j)
		{
			if (area[i][j] == start)
			{
				for (int k = 0; k < 4; ++k)
				{
					q.push(Pos(i, j, k));
					dist[i][j][k] = 0;
				}
			}
		}
	}
	while (!q.empty())
	{
		int cy = q.front().y;
		int cx = q.front().x;
		int cd = q.front().d;
		q.pop();
		int ny = cy + dy[cd];
		int nx = cx + dx[cd];
		if (!inRange(ny, nx)) continue;
		if (dist[ny][nx][cd] != -1) continue;
		if (arr[ny][nx] == 0)
		{
			q.push(Pos(ny, nx, cd));
			dist[ny][nx][cd] = dist[cy][cx][cd] + 1;
		}
		else if(dist[cy][cx][cd] > 1)
		{
			int da = start;
			int db = area[ny][nx];
			int val = dist[cy][cx][cd];
			if (conn[da][db] == 0)
				conn[da][db] = conn[db][da] = val;
			else
			{
				conn[da][db] = min(conn[da][db], val);
				conn[db][da] = conn[da][db];
			}
		}
	}
}

void dfs(int y, int x, int cnt)
{
	for (int i = 0; i < 4; ++i)
	{
		int ny = y + dy[i];
		int nx = x + dx[i];
		if (inRange(ny, nx) == false) continue;
		if (arr[ny][nx] && area[ny][nx] == 0)
		{
			area[ny][nx] = cnt;
			dfs(ny, nx, cnt);
		}
	}
}

void dfsAll()
{
	areaCnt = 0;
	for (int i = 0; i < r; ++i)
	{
		for (int j = 0; j < c; ++j)
		{
			if (arr[i][j] && area[i][j] == 0)
			{
				area[i][j] = ++areaCnt;
				dfs(i, j, areaCnt);
			}
		}
	}
}


int ans = -1;
vector<int> v;

void fdfs(int sum)
{
	if (v.size() == areaCnt)
	{
		if (ans == -1) ans = sum;
		else ans = min(ans, sum);
		return;
	}
	int vlen = v.size();
	for (int i = 0; i < vlen; ++i)
	{
		int cur = v[i];
		for (int j = 1; j <= areaCnt; ++j)
		{
			if (visited[j] == false && conn[cur][j] > 0)
			{
				visited[j] = true;
				v.push_back(j);
				fdfs(sum + conn[cur][j]);
				visited[j] = false;
				v.pop_back();
			}
		}
	}
}

int main(void)
{
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	cin >> r >> c;
	for (int i = 0; i < r; ++i)
	{
		for (int j = 0; j < c; ++j)
		{
			cin >> arr[i][j];
		}
	}
	dfsAll();
	for (int i = 1; i <= areaCnt; ++i)
	{
		bfs(i);
	}
	// 모든 경로를 만들어보고 최소값을 찾는다.
	visited[1] = true;
	v.push_back(1);
	fdfs(0);
	cout << ans;
	return 0;
}