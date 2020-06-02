#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;


/*
1. bfs 로 최장 경로의 길이와 각 노드까지의 최대값을 구한다.
2. 길을 알고있으므로 역으로 bfs 하여 간선을 타고 카운트하며 온다.
아래 문장이 없으면 하나의 길이 여러번 더해진다.
dist[next] += dist[cur] + 1; 
dist[cur] = 0;
*/

struct Edge
{
	int to, cost;
	Edge(int _to, int _cost)
		: to(_to), cost(_cost)
	{}
};

int n, m, start, finish, longTime;
vector<vector<Edge>> adj;
vector<vector<Edge>> radj;
vector<int> ind;
vector<int> rind;
vector<int> maxv;
vector<int> dist;
vector<bool> path;

int bfs()
{
	queue<int> q;
	q.push(start);
	while (!q.empty())
	{
		int cur = q.front();
		q.pop();
		int len = adj[cur].size();
		for (int i = 0; i < len; ++i)
		{
			int next = adj[cur][i].to;
			int val = adj[cur][i].cost;
			--ind[next];
			if (maxv[next] < maxv[cur] + val)
			{
				maxv[next] = maxv[cur] + val;
			}
			if (ind[next] == 0) q.push(next);
		}
	}
	return maxv[finish];
}

int rbfs()
{
	queue<int> q;
	q.push(finish);
	path[finish] = true;
	while (!q.empty())
	{
		int cur = q.front();
		q.pop();
		int len = radj[cur].size();
		for (int i = 0; i < len; ++i)
		{
			int next = radj[cur][i].to;
			int val = radj[cur][i].cost;
			--rind[next];
			if ((maxv[next] + val == maxv[cur]) && path[cur])
			{
				path[next] = true;
				if (dist[cur] > 0)
				{
					dist[next] += dist[cur] + 1;
					dist[cur] = 0;
				}
				else dist[next] += 1;
			}
			if (rind[next] == 0) q.push(next);
		}
	}
	return dist[start];
}

int main(void)
{
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	cin >> n >> m;
	adj = vector<vector<Edge>>(n + 1);
	radj = vector<vector<Edge>>(n + 1);
	ind = vector<int>(n + 1);
	rind = vector<int>(n + 1);
	maxv = vector<int>(n + 1);
	dist = vector<int>(n + 1);
	path = vector<bool>(n + 1);
	for (int i = 0; i < m; ++i)
	{
		int a, b, val;
		cin >> a >> b >> val;
		adj[a].push_back(Edge(b, val));
		radj[b].push_back(Edge(a, val));
		++ind[b];
		++rind[a];
	}
	cin >> start >> finish;
	cout << bfs() << '\n';
	cout << rbfs();
	return 0;
}
