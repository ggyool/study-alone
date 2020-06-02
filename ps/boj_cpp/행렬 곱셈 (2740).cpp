#include <iostream>
#include <algorithm>
using namespace std;

int n, m, k;
int arr[100][100], brr[100][100], res[100][100];

int main(void)
{
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cin >> n >> m;
	for (int i = 0; i < n; ++i)
	{
		for (int j = 0; j < m; ++j)
		{
			cin >> arr[i][j];
		}
	}
	cin >> m >> k;
	for (int i = 0; i < m; ++i)
	{
		for (int j = 0; j < k; ++j)
		{
			cin >> brr[i][j];
		}
	}
	for (int i = 0; i < n; ++i)
	{
		for (int j = 0; j < m; ++j)
		{
			for (int w = 0; w < k; ++w)
			{
				res[i][w] += arr[i][j] * brr[j][w];
			}
		}
	}
	for (int i = 0; i < n; ++i)
	{
		for (int w = 0; w < k; ++w)
		{
			cout << res[i][w] << ' ';
		}
		cout << '\n';
	}
	return 0;
}