#include <iostream>
#include <algorithm>
#include <vector>
#include <cmath>
using namespace std;

typedef long long int lld;

struct Pos
{
	lld y, x;
	Pos() : y(0), x(0) {}
	Pos(lld a, lld b) : y(a), x(b) {}
};

struct Edge
{
	int from, to;
	lld distSquare;
	Edge(int _from, int _to, lld _distSquare)
		: from(_from), to(_to), distSquare(_distSquare) {}
	bool operator<(const Edge &ref) const
	{
		return distSquare < ref.distSquare;
	}
};


vector<Pos> pv;
vector<int> p;
int n, m;

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
	cout << fixed;
	cout.precision(2);
	cin >> n >> m;
	pv = vector<Pos>(n + 1);
	p = vector<int>(n + 1);
	for (int i = 1; i <= n; ++i) p[i] = i;
	for (int i = 1; i <= n; ++i)
	{
		cin >> pv[i].y >> pv[i].x;
	}
	for (int i = 0; i < m; ++i)
	{
		int x, y;
		cin >> x >> y;
		Union(x, y);
	}

	vector<Edge> ev;
	for (int i = 1; i <= n-1; ++i)
	{
		for (int j = i + 1; j <= n; ++j)
		{
			long dist = 0;
			dist += (pv[i].y - pv[j].y) * (pv[i].y - pv[j].y);
			dist += (pv[i].x - pv[j].x) * (pv[i].x - pv[j].x);
			ev.push_back(Edge(i, j, dist));
		}
	}
	sort(ev.begin(), ev.end());
	double ans = 0.;
	int cnt = 0;
	int len = ev.size();
	for (int i = 0; i < len; ++i)
	{
		int from = ev[i].from;
		int to = ev[i].to;
		lld dstSqr = ev[i].distSquare;
		int x = find(from);
		int y = find(to);
		if (x != y)
		{
			Union(x, y);
			ans += sqrt(dstSqr);
			++cnt;
		}
		if (cnt + m == n - 1) break;
	}
	cout << ans << '\n';

	return 0;
}