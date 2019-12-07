#include <iostream>
#include <string>
#include <cstring>
using namespace std;

// 우선순위 경로를 다 연결한다고 하면
// ind 개수가 0인 노드부터 n-1 노드 순으로 방문해야한다.
// 정상적인 입력이라면 '?' 없음
int arr[501];
int n, m;
int ind[501]; 
// 처음 우선순위 작을수록 앞~
int comp[501];
// seq[0]: ind가 0 인 사람 number
int seq[501];

string s, strNum;

int main(void)
{
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	int tc;
	cin >> tc;
	for (int t = 0; t < tc; ++t)
	{
		cin >> n;
		seq[0] = -1;
		for (int i = 1; i <= n; ++i)
		{
			cin >> arr[i];
			ind[arr[i]] = i - 1;
			comp[arr[i]] = i;
			seq[arr[i]] = -1;
		}
		cin >> m;
		for (int i = 0; i < m; ++i)
		{
			int a, b, from, to;
			cin >> a >> b;
			if(comp[a] < comp[b]) from = a, to = b;
			else from = b, to = a;
			--ind[to];
			++ind[from];
		}
		bool flag = true;
		for (int i = 1; i <= n; ++i)
		{
			if (seq[ind[i]] != -1)
			{
				flag = false;
				break;
			}
			seq[ind[i]] = i;
		}
		if (flag)
		{
			for (int i = 0; i < n; ++i)
			{
				cout << seq[i] << ' ';
			}
		}
		else cout << "IMPOSSIBLE";
		cout << '\n';
	}
}
