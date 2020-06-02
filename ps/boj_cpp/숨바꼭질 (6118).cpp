#include <iostream>
#include <algorithm>
#include <queue>
#include <vector>
using namespace std;


int n, m;
const int INF = (int)1e8;
vector<vector<int>> adj;
vector<bool> visited;
vector<int> dist;
int target = 1, targetDist = 0, targetCnt = 1;

void bfs()
{
	queue<int> q;
	visited[1] = true;
	dist[1] = 0;
	q.push(1);
	while (!q.empty())
	{
		int cur = q.front();
		q.pop();
		int len = adj[cur].size();
		for (int i = 0; i < len; ++i)
		{
			int next = adj[cur][i];
			if (visited[next] || dist[next] < dist[cur] + 1) continue;
			visited[next] = true;
			dist[next] = dist[cur] + 1;
			if (targetDist < dist[next])
			{
				targetDist = dist[next];
				target = next;
				targetCnt = 1;
				
			}
			else if(targetDist == dist[next])
			{
				target = min(target, next);
				++targetCnt;
			}
			q.push(next);
		}
	}
}

int main(void)
{
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	cin >> n >> m;
	adj = vector<vector<int>>(n + 1);
	visited = vector<bool>(n + 1);
	dist = vector<int>(n + 1, INF);
	for (int i = 0; i < m; ++i)
	{
		int a, b;
		cin >> a >> b;
		adj[a].push_back(b);
		adj[b].push_back(a);
	}
	bfs();
	cout << target << ' ' << targetDist << ' ' << targetCnt << '\n';
	return 0;
}