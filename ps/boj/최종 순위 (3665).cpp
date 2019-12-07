#include <iostream>
#include <string>
#include <vector>
#include <queue>
#include <cstring>
using namespace std;

// 처음 풀이 - bfs 위상정렬
// 끝까지 순회하지 못하면 IMPOSSIBLE
// queue에 2개 들어가면 ? 라고 생각했음

// -1 앞이 우선, 0 nocon, 1 뒤가 우선
int conn[501][501];
int arr[501];
int n, m;
int ind[501];
string s, strNum;
vector<int> path;


int topologicalSort()
{
	path.clear();
	queue<int> q;
	for (int i = 1; i <= n; ++i)
	{
		if (ind[i] == 0) q.push(i);
	}
	while (!q.empty())
	{
		if (q.size() != 1) return -1;
		int cur = q.front();
		path.push_back(cur);
		q.pop();
		for (int i = 1; i <= n; ++i)
		{
			if (cur == i) continue;
			if (conn[cur][i] >= 0) continue;
			--ind[i];
			if (ind[i] == 0)
			{
				q.push(i);
			}
		}
	}
	return 0;
}


int main(void)
{
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	int tc;
	cin >> tc;
	for (int t = 0; t < tc; ++t)
	{
		memset(ind, 0, sizeof(ind));
		cin >> n;
		cin.ignore();
		getline(cin, s);
		int slen = s.size();
		int idx = 0;
		for (int i = 0; i < slen; ++i)
		{
			strNum = "";
			while (i<slen)
			{
				if (s[i] == ' ')  break;
				strNum += s[i];
				++i;
			}
			arr[idx++] = stoi(strNum);
		}
		for (int i = 0; i < n - 1; ++i)
		{
			for (int j = i+1; j < n; ++j)
			{
				int from = arr[i];
				int to = arr[j];
				conn[from][to] = -1;
				conn[to][from] = 1;
				++ind[to];
			}
		}
		cin >> m;
		for (int i = 0; i < m; ++i)
		{
			int a, b, from, to;
			cin >> a >> b;
			if (conn[a][b] < 0) from = a, to = b;
			else from = b, to = a;
			--ind[to];
			++ind[from];
			conn[from][to] *= -1;
			conn[to][from] *= -1;
		}
		if (topologicalSort() == -1) cout << "?\n";
		else
		{
			int plen = path.size();
			if (plen != n) cout << "IMPOSSIBLE\n";
			else
			{
				for (int j = 0; j < plen; ++j)
				{
					cout << path[j] << ' ';
				}
				cout << '\n';
			}
		}
	}
}
