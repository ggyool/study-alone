#include <iostream>
#include <algorithm>
#include <queue>
#include <vector>
using namespace std;


struct Pos
{
	int val, idx;
	Pos(int a, int b)
		: val(a), idx(b) {}
	bool operator<(const Pos& ref) const
	{
		return val < ref.val;
	}
};

struct Edge
{
	int cost, from, to;
	Edge(int a, int b, int c)
		: cost(a), from(b), to(c) {}
	bool operator<(const Edge& ref) const
	{
		return cost < ref.cost;
	}
};

int n;
vector<Pos> vx, vy, vz;
vector<Edge> ve;
int p[(int)1e5];

int find(int x)
{
	if (p[x] == x) return x;
	return p[x] = find(p[x]);
}

void Union(int x, int y)
{
	x = find(x);
	y = find(y);
	p[y] = x;
}


int main(void)
{
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	cin >> n;
	for (int i = 0; i < n; ++i)
	{
		p[i] = i;
		int x, y, z;
		cin >> x >> y >> z;
		vx.push_back(Pos(x, i));
		vy.push_back(Pos(y, i));
		vz.push_back(Pos(z, i));
	}
	sort(vx.begin(), vx.end());
	sort(vy.begin(), vy.end());
	sort(vz.begin(), vz.end());

	for (int i = 1; i < n; ++i)
	{
		ve.push_back(Edge(vx[i].val - vx[i - 1].val, vx[i].idx, vx[i-1].idx));
		ve.push_back(Edge(vy[i].val - vy[i - 1].val, vy[i].idx, vy[i - 1].idx));
		ve.push_back(Edge(vz[i].val - vz[i - 1].val, vz[i].idx, vz[i - 1].idx));
	}
	sort(ve.begin(), ve.end());
	// kruskal
	int len = ve.size();
	long long sum = 0;
	int edgeCnt = 0;
	for (int i = 0; i < len; ++i)
	{
		int from = ve[i].from;
		int to = ve[i].to;
		from = find(from);
		to = find(to);
		if (from != to)
		{
			Union(from, to);
			sum += ve[i].cost;
			edgeCnt++;
			if (edgeCnt == n - 1) break;
		}
	}
	cout << sum;
}