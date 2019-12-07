#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;


struct Edge
{
	int to, cost;
	Edge(int _to, int _cost)
		: to(_to), cost(_cost)
	{}
};

int n, m, start, finish, longTime;
vector<vector<Edge>> adj;
vector<int> back;
vector<bool> visited;

/* DFS
메모이제이션 안 하면 TLE
1. 도착점 까지 가장 먼 경로를 저장한다. (back배열)
2. 긴 경로들의 edge 개수를 센다.
*/

int dfs(int cur)
{	
	int &ret = back[cur];
	if (ret != -1) return ret;
	ret = 0;
	int len = adj[cur].size();
	for (int i = 0; i < len; ++i)
	{
		int next = adj[cur][i].to;
		int val = adj[cur][i].cost;
		ret = max(ret, dfs(next) + val);
	}
	return ret;
}

int fdfs(int cur, int sum)
{
	int len = adj[cur].size();
	int ret = 0;
	for (int i = 0; i < len; ++i)
	{
		int next = adj[cur][i].to;
		int val = adj[cur][i].cost;
		if (sum + val + back[next] == longTime)
		{
			if (visited[next]) ret += 1;
			else
			{
				visited[next] = true;
				ret += 1 + fdfs(next, sum + val);
			}
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
	adj = vector<vector<Edge>>(n + 1);
	back = vector<int>(n + 1, -1);
	for (int i = 0; i < m; ++i)
	{
		int a, b, val;
		cin >> a >> b >> val;
		adj[a].push_back(Edge(b, val));
	}
	cin >> start >> finish;
	longTime = dfs(start);
	cout << longTime << '\n';

	visited = vector<bool>(n + 1);
	visited[start] = true;
	cout << fdfs(start, 0);
	return 0;
}