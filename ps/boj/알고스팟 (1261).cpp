#include <algorithm>
#include <iostream>
#include <queue>
#include <string>
using namespace std;

struct Node
{
	int y, x, shortDist;
	Node(int a, int b, int c)
		: y(a), x(b), shortDist(c) {}
	// minHeap
	bool operator<(const Node &ref) const
	{
		return shortDist > ref.shortDist;
	}
};

const int INF = (int)1e8;
const int dy[4] = {0,1,0,-1};
const int dx[4] = {1,0,-1,0};
int n, m;
int arr[101][101];
int dist[101][101];
bool visited[101][101];

bool inRange(int y, int x)
{
	if (y<1 || x<1 || y>n || x>m) return false;
	return true;
}

int daijkstra()
{
	priority_queue<Node> pq;
	pq.push(Node(1,1,0));
	dist[1][1] = 0;
	while (!pq.empty())
	{
		int cy = pq.top().y;
		int cx = pq.top().x;
		// 안 넣어도 pass
		if (visited[cy][cx]) continue;
		visited[cy][cx] = true;
		pq.pop();
		for (int i = 0; i < 4; ++i)
		{
			int ny = cy + dy[i];
			int nx = cx + dx[i];
			if (inRange(ny, nx) && dist[ny][nx] > dist[cy][cx] + arr[ny][nx])
			{
				dist[ny][nx] = dist[cy][cx] + arr[ny][nx];
				pq.push(Node(ny,nx,dist[ny][nx]));
			}
		}
	}
	return dist[n][m];
}

int main(void)
{
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	string s;
	cin >> m >> n;
	for (int i = 1; i <= n; ++i)
	{
		cin >> s;
		for (int j = 1; j <= m; ++j)
		{
			arr[i][j] = s[j-1] - '0';
			dist[i][j] = INF;
		}
	}
	cout << daijkstra();
	return 0;
}
