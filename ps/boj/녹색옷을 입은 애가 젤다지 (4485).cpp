#include <iostream>
#include <algorithm>
#include <queue>
#include <vector>
using namespace std;

struct Pos{
	int y, x, val;
	Pos(int a, int b, int c) : y(a), x(b), val(c) {}
	bool operator<(const Pos &ref) const
	{
		return val > ref.val;
	}
};

const int INF = (int)1e8;
const int dy[4] = {0,1,0,-1};
const int dx[4] = {1,0,-1,0};
int arr[125][125];
vector<vector<int>> dist;
int n;

bool inRange(int y, int x)
{
	if (y < 0 || x < 0 || y >= n || x >= n) return false;
	return true;
}

int dijkstra()
{
	dist[0][0] = arr[0][0];
	priority_queue<Pos> pq;
	pq.push(Pos(0,0,dist[0][0]));
	while (!pq.empty())
	{
		int cy = pq.top().y;
		int cx = pq.top().x;
		int cv = pq.top().val;
		if (dist[cy][cx] < cv) continue;
		pq.pop();
		for (int i = 0; i < 4; ++i)
		{
			int ny = cy + dy[i];
			int nx = cx + dx[i];
			if (!inRange(ny, nx)) continue;
			if (dist[ny][nx] > dist[cy][cx] + arr[ny][nx])
			{
				dist[ny][nx] = dist[cy][cx] + arr[ny][nx];
				pq.push(Pos(ny,nx,dist[ny][nx]));
			}
		}
	}
	return dist[n-1][n - 1];
}

int main(void)
{
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	int tc = 0;
	while (true)
	{
		++tc;
		cin >> n;
		if (n == 0) break;
		dist = vector<vector<int>>(n, vector<int>(n, INF));
		for (int i = 0; i < n; ++i)
		{
			for (int j = 0; j < n; ++j)
			{
				cin >> arr[i][j];
			}
		}
		cout << "Problem " << tc << ": " << dijkstra() << '\n';
	}
	return 0;
}