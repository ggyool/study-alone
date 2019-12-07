#include <iostream>
#include <algorithm>
#include <queue>
using namespace std;

struct Edge
{
	int x, y, cost;
	Edge(int a, int b, int c)
		: x(a), y(b), cost(c) {}
	bool operator<(const Edge& ref) const
	{
		return cost > ref.cost;
	}
};

const int INF = (int)1e8;
int n;
int shortDist[21][21];
int direct;

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
			cin >> shortDist[i][j];
		}
	}
	priority_queue<Edge> pq;
	for (int i = 1; i <= n; ++i)
	{
		for (int j = i + 1; j <= n; ++j)
		{
			pq.push(Edge(i,j, shortDist[i][j]));
		}
	}
	while (!pq.empty())
	{
		int from = pq.top().x;
		int to = pq.top().y;
		int cur = pq.top().cost;
		pq.pop();
		bool flag = true;
		for (int k = 1; k <= n; ++k)
		{
			if (k == from || k == to) continue;
			if (cur == shortDist[from][k] + shortDist[k][to])
			{
				flag = false;
				break;
			}
			else if (cur > shortDist[from][k] + shortDist[k][to])
			{
				cout << -1;
				return 0;
			}
		}
		if (flag)
		{
			direct += cur;
		}
	}
	cout << direct;
	return 0;
}