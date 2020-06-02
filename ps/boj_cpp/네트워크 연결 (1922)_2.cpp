#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

struct Edge
{
	int from, to, cost;
	Edge(int a, int b, int c)
	{
		from = a, to = b, cost = c;
	}
	bool operator<(const Edge &ref) const
	{
		return cost < ref.cost;
	}
};

int n, m;
vector<Edge> v;
vector<int> p;

int Find(int x)
{
	if (p[x] == x) return x;
	return p[x] = Find(p[x]);
}

void Union(int x, int y)
{
	x = Find(x);
	y = Find(y);
	p[y] = x;
}

int mstKruskal()
{
	int ret = 0;
	int len = v.size();
	for (int i = 0; i < len; ++i)
	{
		int x = v[i].from;
		int y = v[i].to;
		int c = v[i].cost;
		int px = Find(x);
		int py = Find(y);
		if (px != py)
		{
			ret += c;
			Union(px, py);
		}
	}
	return ret;
}

int main(void)
{
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	cin >> n >> m;
	p = vector<int>(n + 1);
	for(int i=1; i<=n; ++i)
		p[i] = i;
	for (int i = 1; i <= m; ++i)
	{
		int x, y, z;
		cin >> x >> y >> z;
		v.push_back(Edge(x, y, z));
	}
	sort(v.begin(), v.end());
	cout << mstKruskal();

	return 0;
}