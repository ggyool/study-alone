#include <iostream>
#include <queue>
#include <vector>
using namespace std;

struct Task
{
	int num, endTime;
	Task(int _num = 0, int _endTime = 0)
		: num(_num), endTime(_endTime)
	{}
	bool operator<(const Task &ref) const
	{
		return endTime > ref.endTime;
	}
};

int n, m;
vector<vector<int>> adj;
vector<int> useTime;
vector<int> ind;

/*
pq 에 endTime 으로 minHeap을 만들고,
작업이 끝나는 순간 다음작업을 할 수 있는지 (indgree == 0 )이 되는지 체크하여 pq에 넣는다.
*/

int solve()
{
	priority_queue<Task> pq;
	for (int i = 1; i <= n; ++i)
	{
		if (ind[i] == 0)
		{
			pq.push(Task(i, useTime[i]));
		}
	}
	int curTime = 0;
	while (!pq.empty())
	{
		while (!pq.empty())
		{
			Task cur = pq.top();
			int endTime = cur.endTime;
			int num = cur.num;
			if (endTime == curTime)
			{
				pq.pop();
				int len = adj[num].size();
				for (int i = 0; i < len; ++i)
				{
					int next = adj[num][i];
					--ind[next];
					if (ind[next] == 0)
					{
						pq.push(Task(next, endTime + useTime[next]));
					}
				}
			}
			else break;
		}
		if(!pq.empty()) ++curTime;
	}
	return curTime;
}

int main(void)
{
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	cin >> n;
	adj = vector<vector<int>>(n + 1);
	useTime = vector<int>(n + 1);
	ind = vector<int>(n + 1, 0);
	for (int i = 1; i <= n; ++i)
	{
		cin >> useTime[i];
		cin >> m;
		for (int j = 0; j < m; ++j)
		{
			int target;
			cin >> target;
			adj[target].push_back(i);
			++ind[i];
		}
	}
	cout << solve();
	return 0;
}