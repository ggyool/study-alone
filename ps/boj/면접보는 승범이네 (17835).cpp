#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
using namespace std;

typedef long long int lld;

struct Edge
{
	int to, cost;
	Edge(int a, int b)
		: to(a), cost(b) {}
};

struct Node
{
	int idx, shortDist;
	Node(int a, int b) : idx(a), shortDist(b) {}
	bool operator<(const Node& ref) const
	{
		if (shortDist == ref.shortDist) return idx > ref.idx;
		return shortDist > ref.shortDist;
	}
};

const lld INF = (lld)1e11;
int n, m, k;
vector<vector<Edge>> adj;
vector<lld> dist;
bool isGoal[(int)1e5 + 1];
priority_queue<Node> pq;

void daijkstra()
{
	for (int i = 1; i <= n; ++i)
	{
		if (isGoal[i])
		{
			dist[i] = 0;
			int len = adj[i].size();
			for (int j = 0; j < len; ++j)
			{
				int next = adj[i][j].to;
				if (dist[next] > dist[i] + adj[i][j].cost)
				{
					dist[next] = dist[i] + adj[i][j].cost;
					pq.push(Node(next, dist[next]));
				}
			}
		}
	}
	while (!pq.empty())
	{
		int cur = pq.top().idx;
		int curDist = pq.top().shortDist;
		pq.pop();
		if (curDist > dist[cur]) continue;
		int len = adj[cur].size();
		for (int i = 0; i < len; ++i)
		{
			int next = adj[cur][i].to;
			if (dist[next] > dist[cur] + adj[cur][i].cost)
			{
				dist[next] = dist[cur] + adj[cur][i].cost;
				pq.push(Node(next, dist[next]));
			}
		}
	}
}


int main(void)
{
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	cin >> n >> m >> k;
	adj = vector<vector<Edge>>(n + 1);
	dist = vector<lld>(n + 1, INF);
	for (int i = 0; i < m; ++i)
	{
		int a, b, c;
		cin >> a >> b >> c;
		// reverse 하여 저장
		adj[b].push_back(Edge(a, c));
	}
	for (int i = 0; i < k; ++i)
	{
		int a;
		cin >> a;
		isGoal[a] = true;
	}
	daijkstra();
	
	int farPeople;
	lld farDist = -1;
	for (int i = 1; i <= n; ++i)
	{
		if (!isGoal[i] && dist[i]!=INF)
		{
			if (farDist == dist[i])
				farPeople = min(farPeople, i);
			else if (farDist < dist[i])
			{
				farDist = dist[i];
				farPeople = i;
			}
		}
	}
	cout << farPeople << '\n';
	cout << farDist;
	return 0;
}