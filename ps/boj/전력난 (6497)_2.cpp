#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

struct Edge
{
	int from, to, cost;
	Edge(int x, int y, int z)
		: from(x), to(y), cost(z) {}
	bool operator<(const Edge &ref) const
	{
		return cost < ref.cost;
	}
};
const int MAX = 200000;
int p[MAX];
int n, m, total;
vector<Edge> adj;

int find(int x)
{
	if (x == p[x]) return x;
	return p[x] = find(p[x]);
}

void Union(int x, int y)
{
	x = find(x);
	y = find(y);
	p[y] = x;
}

// mst를 구성하는 간선의 합을 return 한다.
int mstKruskal()
{
	int ret = 0;
	sort(adj.begin(), adj.end());
	for (int i = 0; i < m; ++i)
	{
		int x = adj[i].from;
		int y = adj[i].to;
		x = find(x);
		y = find(y);
		if (x == y) continue;
		Union(x, y);
		ret += adj[i].cost;
	}
	return ret;
}

int main(void) 
{
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	while (true)
	{
		cin >> n >> m;
		if (n == 0) break;
		adj.clear();
		total = 0;
		for (int i = 0; i < n; ++i) p[i] = i;
		for (int i = 0; i < m; ++i)
		{
			int x, y, z;
			cin >> x >> y >> z;
			adj.push_back(Edge(x,y,z));
			total += z;
		}
		cout << total - mstKruskal() << '\n';
	}
	return 0;
}