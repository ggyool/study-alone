#include <iostream>
#include <vector>
#include <algorithm>
#include <cstring>
#include <string>
#include <set>
using namespace std;

int n;
int arr[10];
vector<int> adj[10];
bool visited[10];
bool team[10];
const int BIG = 987654321;
int ans = BIG;

int dfs(int cur)
{
	int ret = 1;
	int len = adj[cur].size();
	for (int i = 0; i < len; ++i)
	{
		int next = adj[cur][i];
		if (visited[next] == false && team[cur] == team[next])
		{
			visited[next] = true;
			ret += dfs(next);
		}
	}
	return ret;
}

void calcAns()
{
	int sa = 0;
	int sb = 0;
	for (int i = 0; i < n; ++i)
	{
		if (team[i]) sa += arr[i];
		else sb += arr[i];
	}
	int tmp = sa - sb;
	if (tmp < 0) tmp *= -1;
	ans = min(ans, tmp);
}

void pick(int pickN, int idx)
{
	if (idx == n) 
	{
		// dfs 2번 돌려서 모든 노드를 방문했다면, 두 컴포넌트로 나눠져있는 것
		int memA = 0, memB = 0;
		if (pickN < n)
		{
			memset(visited, false, sizeof(visited));
			visited[0] = true;
			memA = dfs(0);
			if (memA == pickN)
			{
				
				for (int i = 0; i < n; ++i)
				{
					if (team[i] == false)
					{
						visited[i] = true;
						memB = dfs(i);
						break;
					}
				}
				if (memB == n - memA) calcAns();
			}
		}
		return;
	}
	team[idx] = true;
	pick(pickN + 1, idx + 1);
	team[idx] = false;
	pick(pickN, idx + 1);
}

int main(void)
{
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	cin >> n;
	for (int i = 0; i < n; ++i)
		cin >> arr[i];
	for (int i = 0; i < n; ++i)
	{
		int m, t;
		cin >> m;
		for (int j = 0; j < m; ++j)
		{
			cin >> t;
			adj[i].push_back(t-1);
		}
	}
	team[0] = true;
	pick(1, 1);
	if (ans == BIG) cout << -1;
	else cout << ans;
	return 0;
}