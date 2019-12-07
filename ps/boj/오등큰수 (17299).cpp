#include <iostream>
#include <stack>
using namespace std;

int arr[1000001];
int cnt[1000001];
int ans[1000001];
int n;

int main(void)
{
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	cin >> n;
	for (int i = 1; i <= n; ++i)
	{
		cin >> arr[i];
		++cnt[arr[i]];
		ans[i] = -1;
	}
	stack<int> stk;
	for (int i = 1; i <= n; ++i)
	{
		if (stk.empty())
		{
			stk.push(i);
			continue;
		}
		while (true)
		{
			if (stk.empty() || cnt[arr[stk.top()]] >= cnt[arr[i]])
			{
				stk.push(i);
				break;
			}
			else
			{
				ans[stk.top()] = arr[i];
				stk.pop();
			}
		}
	}
	for (int i = 1; i <= n; ++i)
	{
		cout << ans[i] << ' ';
	}
	return 0;
}