#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

long long int fact[21];
bool c[21];

void preCalc()
{
	fact[0] = 1;
	for (int i = 1; i <= 20; ++i)
	{
		fact[i] = fact[i - 1] * i;
	}
}

void printVector(vector<int> &vec)
{
	int len = vec.size();
	for (int i = 0; i < len; ++i)
	{
		cout << vec[i] << ' ';
	}
	cout << '\n';
}


int main(void)
{
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	preCalc();
	int n;
	cin >> n;
	vector<int> vec(n);
	int q;
	cin >> q;
	if (q == 1)
	{
		vector<int> ans;
		long long int cnt;
		cin >> cnt;
		for (int i = 0; i < n; ++i)
		{
			int j;
			for (j = 1; j <= n; ++j)
			{
				if (c[j]) continue;	
				if (cnt > fact[n - i - 1])
				{
					cnt -= fact[n - i - 1];
				}
				else
				{
					ans.push_back(j);
					c[j] = true;
					break;
				}
			}
		}
		printVector(ans);
	}
	else if (q == 2)
	{
		for (int i = 0; i < n; ++i) cin >> vec[i];
		long long int ans = 0;
		for (int i = 0; i < n; ++i)
		{
			for (int j = 1; j < vec[i]; ++j)
			{
				if (c[j]) continue;
				ans += fact[n - i - 1];
			}
			c[vec[i]] = true;
		}
		cout << ans + 1;
	}


	return 0;
}