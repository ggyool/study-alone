#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

// kruskal 으로 mst 구하고 가장 긴 하나의 선을 끊는다

struct Edge
{
	int from, to, cost;
	Edge(int a, int b, int c)
		: from(a), to(b), cost(c) {}
	bool operator<(const Edge& ref) const
	{
		return cost < ref.cost;
	}
};

int n, m, maxVal, sum;
vector<Edge> v;
vector<int> p;

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

void mstKruskal()
{
	int edgeCnt = 0;
	sort(v.begin(), v.end());
	for (int i = 0; i < m; ++i)
	{
		int from = v[i].from;
		int to = v[i].to;
		int cost = v[i].cost;
		int px = find(from);
		int py = find(to);
		if (px == py) continue;
		Union(px, py);
		sum += cost;
		maxVal = max(maxVal, cost);
		++edgeCnt;
		if (edgeCnt == n - 1) break;
	}
}

int main(void)
{
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	cin >> n >> m;
	p = vector<int>(n + 1);
	for (int i = 1; i <= n; ++i) p[i] = i;
	for (int i = 0; i < m; ++i)
	{
		int a, b, c;
		cin >> a >> b >> c;
		v.push_back(Edge(a,b,c));
	}
	mstKruskal();
	cout << sum - maxVal << '\n';
	return 0;
}

