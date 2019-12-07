#include <iostream>
#include <vector>
#include <algorithm>
#include <set>
#include <cstdlib>
using namespace std;

struct Edge
{
	int to, cost;
	Edge(int a, int b)
		:to(a), cost(b) {}
};

struct Node
{
	int idx, shortDist;
	Node(int a, int b)
		: idx(a), shortDist(b) {}
	// ascending set
	bool operator<(const Node &ref) const
	{
		if (shortDist == ref.shortDist)  return idx < ref.idx;
		return shortDist < ref.shortDist;
	}
	/*
	// 런타임에러 코드 Strict weak ordering
	// Node(1,3) 이랑 Node(2,3) 이랑 같다고 본다.
	bool operator<(const Node &ref) const
	{
		return shortDist < ref.shortDist;
	}*/
};

const int INF = (int)1e8;
int n, m, sta;
vector<vector<Edge>> adj;
vector<int> dist;
vector<bool> visited;
set<Node> st;

void daijkstra()
{
	dist[sta] = 0;
	st.insert(Node(sta, dist[sta]));
	while (!st.empty())
	{
		int cur = st.begin()->idx;
		st.erase(st.begin());
		int len = adj[cur].size();
		for (int i = 0; i < len; ++i)
		{
			int next = adj[cur][i].to;
			if (dist[next] > dist[cur] + adj[cur][i].cost)
			{
				// 있으면 지우고 새로운 값을 넣는다.
				if ( dist[next] != INF  ) st.erase(st.find(Node(next, dist[next])));
				dist[next] = dist[cur] + adj[cur][i].cost;
				st.insert(Node(next, dist[next]));
			}
		}
	}
}

int main(void)
{
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	cin >> n >> m >> sta;
	adj = vector<vector<Edge>>(n + 1);
	dist = vector<int>(n + 1, INF);
	visited = vector<bool>(n + 1);
	for (int i = 0; i < m; ++i)
	{
		int a, b, c;
		cin >> a >> b >> c;
		adj[a].push_back(Edge(b, c));
	}
	daijkstra();
	for (int i = 1; i <= n; ++i)
	{
		if (dist[i] >= INF) cout << "INF\n";
		else cout << dist[i] << '\n';
	}
	return 0;
}