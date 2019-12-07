#include <algorithm>
#include <vector>
#include <iostream>
using namespace std;

/*
1
3 1 1
2 3 1
2 3 2
-----------
yes ?몃뜲 no ?⑤뒗 肄붾뱶??pass ?쒕떎.
*/

struct Edge
{
	int from, to, cost;
	Edge(int a, int b, int c)
		: from(a), to(b), cost(c)
	{}
};

int n, m, w;
const int INF = 987654321;
vector<Edge> v;
vector<int> dist;

bool bellmanFord()
{
	dist[1] = 0;
	int vlen = v.size();
	for (int t = 0; t < n; ++t)
	{
		for (int i = 0; i < vlen; ++i)
		{
			int x = v[i].from;
			int y = v[i].to;
			int z = v[i].cost;
			//if (dist[x] == INF) continue;
			if (dist[y] > dist[x] + z)
			{
				if (t == n - 1) return true;
				dist[y] = dist[x] + z;
			}
		}
	}
	return false;
}

int main(void)
{
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	int tc;
	cin >> tc;
	while (tc--)
	{
		cin >> n >> m >> w;
		v.clear();
		dist = vector<int>(n + 1, INF);
		for (int i = 0; i < m; ++i)
		{
			int a, b, c;
			cin >> a >> b >> c;
			v.push_back(Edge(a, b, c));
			v.push_back(Edge(b, a, c));
		}
		for (int i = 0; i < w; ++i)
		{
			int a, b, c;
			cin >> a >> b >> c;
			v.push_back(Edge(a, b, -c));
		}
		if (bellmanFord()) cout << "YES\n";
		else cout << "NO\n";
	}

	return 0;
}