#include <iostream>
#include <algorithm>
#include <queue>
using namespace std;

// bfs

int n, m;
bool arr[201][201];
bool isPlan[201];
bool visited[201];
int start = -1;

void bfs()
{
	queue<int> q;
	visited[start] = true;
	q.push(start);
	while (!q.empty())
	{
		int cur = q.front();
		q.pop();
		for (int i = 1; i <= n; ++i)
		{
			if (arr[cur][i] && !visited[i])
			{
				visited[i] = true;
				q.push(i);
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
	for (int i = 1; i <= n; ++i)
	{
		for (int j = 1; j <= n; ++j)
		{
			cin >> arr[i][j];
		}
	}
	for (int i = 0; i < m; ++i)
	{
		int a;
		cin >> a;
		if (start == -1) start = a;
		isPlan[a] = true;
	}
	bfs();
	bool ans = true;
	for (int i = 1; i <= n; ++i)
	{
		if (isPlan[i] && !visited[i])
		{
			ans = false;
			break;
		}
	}
	if (ans) cout << "YES";
	else cout << "NO";
	return 0;
}