#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>
using namespace std;

// 문제 조건은 애매하지만 입력은 하나의 컴포넌트라고 생각
// prim 으로 mst 구하고 가장 긴 하나의 선을 끊는다

struct Edge
{
	int to, cost;
	Edge(int a, int b)
		: to(a), cost(b) {}
	bool operator<(const Edge& ref) const
	{
		return cost > ref.cost;
	}
};

int n, m, maxVal, sum;
vector<vector<Edge>> adj;
vector<bool> visited;

void mstPrim()
{
	priority_queue<Edge> pq;
	int start = 1;
	int visitedCnt = 1;
	visited[start] = true;
	int len = adj[start].size();
	for (int i = 0; i < len; ++i)
	{
		pq.push(adj[start][i]);
	}
	while (!pq.empty())
	{
		int cost = pq.top().cost;
		int to = pq.top().to;
		pq.pop();
		if (visited[to]) continue;
		visited[to] = true;
		++visitedCnt;
		sum += cost;
		maxVal = max(maxVal, cost);
		if (visitedCnt == n) break;
		int len = adj[to].size();
		for (int i = 0; i < len; ++i)
		{
			int next = adj[to][i].to;
			if (visited[next] == false)
			{
				pq.push(adj[to][i]);
			}
		}
	}
}

int main(void)
{
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	cin >> n >> m;
	adj = vector<vector<Edge>>(n + 1);
	visited = vector<bool>(n + 1);
	for (int i = 0; i < m; ++i)
	{
		int a, b, c;
		cin >> a >> b >> c;
		adj[a].push_back(Edge(b, c));
		adj[b].push_back(Edge(a, c));
	}
	mstPrim();
	cout << sum - maxVal << '\n';
	return 0;
}

