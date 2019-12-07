#include <iostream>
#include <string>
#include <vector>
using namespace std;

int m, n, mn;
vector<vector<int>> v;
vector<vector<int>> kv[4];
// 채워야 하는 개수를 세어 놓는다/
int lockn;

void printArr()
{
	cout << '\n';
	for (int i = 0; i < mn; ++i)
	{
		for (int j = 0; j < mn; ++j)
		{
			if (v[i][j] == -1) cout << 9 << ' ';
			else cout << v[i][j] << ' ';
		}
		cout << '\n';
	}
}


void rotateKey(int bef, int aft)
{
	for (int i = 0; i < m; ++i)
	{
		for (int j = 0; j<m; ++j)
		{
			kv[aft][j][m - 1 - i] = kv[bef][i][j];
		}
	}
}


bool inRange(int y, int x)
{
	if (y<m - 1 || x<m - 1 || y>mn - m || x>mn - m) return false;
	return true;
}

bool chk(int sty, int stx, int kidx)
{
	int cnt = 0;
	for (int i = 0; i < m; ++i)
	{
		for (int j = 0; j < m;++j)
		{
			int ty = sty + i;
			int tx = stx + j;
			if (!inRange(ty, tx)) continue;
			if (kv[kidx][i][j] == 1)
			{
				if (v[ty][tx] == 0)
				{
					++cnt;
				}
				else
				{
					return false;
				}
			}
		}
	}
	return cnt == lockn;
}

bool solution(vector<vector<int>> key, vector<vector<int>> lock) {
	bool ret = false;
	m = key.size();
	n = lock.size();
	v = vector<vector<int>>(2*(m-1) + n, vector<int>(2*(m-1) + n, -1));
	// 4방향 돌려서 미리 넣어놓기
	for (int i = 0; i < 4; ++i) kv[i] = vector<vector<int>>(m, vector<int>(m, 0));
	for (int i = 0; i < 4; ++i)
	{
		if (i == 0)
		{
			for (int j = 0; j < m; ++j)
			{
				for (int k = 0; k < m; ++k)
				{
					kv[i][j][k] = key[j][k];
				}
			}
		}
		else
		{
			rotateKey(i - 1, i);
		}
	}
	mn = v.size();
	for (int i = 0; i < n; ++i)
	{
		for (int j = 0; j < n; ++j)
		{
			v[i+m-1][j+m-1] = lock[i][j];
			if (lock[i][j] == 0) ++lockn;
		}
	}
	// i,j -> sty, stx
	for (int i = 0; !ret && i <= mn - m; ++i)
	{
		for (int j = 0; !ret && j <= mn - m; ++j)
		{
			for (int kn = 0; !ret && kn < 4; ++kn)
			{
				if (chk(i, j, kn))
				{
					ret = true;
				}
			}
		}
	}
	return ret;
}

int main(void)
{
	vector<vector<int>> a = { {0, 0, 0}, { 1, 0, 0 }, { 0, 1, 1 } };
	vector<vector<int>> b = { { 1,1,1 },{ 1,1, 0 },{ 1, 0, 1 } };
	cout << solution(a, b);
}