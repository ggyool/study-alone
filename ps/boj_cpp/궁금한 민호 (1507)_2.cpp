#include <iostream>
#include <algorithm>
using namespace std;

int n;
int arr[101][101];

int main(void)
{
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	cin >> n;
	for (int i = 1; i <= n; ++i)
	{
		for (int j = 1; j <= n; ++j)
		{
			cin >> arr[i][j];
		}
	}
	for (int k = 1; k <= n; ++k)
	{
		for (int i = 1; i <= n; ++i)
		{
			for (int j = 1; j <= n; ++j)
			{
				if (arr[i][j] == 0 || arr[i][k] == 0 || arr[k][j] == 0) continue;
				if (arr[i][j] > arr[i][k] + arr[k][j])
				{
					cout << -1;
					return 0;
				}
				else if (arr[i][j] == arr[i][k] + arr[k][j])
				{
					arr[i][j] = 0;
					arr[j][i] = 0;
				}
			}
		}
	}
	int ans = 0;
	for (int i = 1; i <= n; ++i)
	{
		for (int j = 1; j <= n; ++j)
		{
			ans += arr[i][j];
		}
	}
	cout << ans / 2;
	return 0;
}