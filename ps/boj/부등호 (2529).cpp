#include <iostream>
#include <queue>
#include <string>
using namespace std;

int n;
char cmp[10];
bool visited[10];
vector<string> ans;
string s;

// true: big
bool bigOrSmall(int cur)
{
	char c = cmp[cur-1];
	return c == '<';
}

void dfs(int cur)
{
	if (cur == n + 1)
	{
		ans.push_back(s);
		return;
	}
	int start, end;
	bool upDown;
	if (cur == 0) start = 0, end = 9, upDown = true;
	else
	{
		upDown = bigOrSmall(cur);
		if (upDown) start = s[cur - 1] - '0' + 1, end =  9;
		else start = 0, end = s[cur - 1] - '0' - 1;
	}
	for (int i = start; i <= end; ++i)
	{
		if (!visited[i])
		{
			visited[i] = true;
			s.push_back(i + '0');
			dfs(cur + 1);
			visited[i] = false;
			s.pop_back();
		}
	}
}

int main(void)
{
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	string inp;
	cin >> n;
	cin.ignore();
	getline(cin, inp);
	for (int i = 0; i < n; ++i)
	{
		cmp[i] = inp[2*i];
	}
	dfs(0);
	cout << ans.back() << '\n';
	cout << ans[0] << '\n';
	return 0;
}