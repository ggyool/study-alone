#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int n, m;

struct Edge
{
	int x, y, cost;
	Edge(int a, int b, int c)
	{
		x = a, y = b, cost = c;
	}
	bool operator<(const Edge &ref) const
	{
		return cost < ref.cost;
	}
};

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
	for (int i = 0;i < len; ++i)
	{
		int x = v[i].x;
		int y = v[i].y;
		int cost = v[i].cost;
		int px = Find(x);
		int py = Find(y);
		if (px != py)
		{
			ret += cost;
			Union(px, py);
			// Find 과정에서 밸런스있게 분포 시켰기 때문에 상관없는듯
			// Union(x, y); 
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
	for (int i = 1; i <= n; ++i)
		p[i] = i;
	for (int i = 0; i < m; ++i)
	{
		int x, y, cost;
		cin >> x >> y >> cost;
		v.push_back(Edge(x, y, cost));
	}
	sort(v.begin(), v.end());
	cout << mstKruskal();
	return 0;
}