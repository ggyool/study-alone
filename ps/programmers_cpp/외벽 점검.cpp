#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;
const int BIG = 987654321;

bool isWeak[200];
bool visited[200];
int wlen, dlen, n;
vector<int> weak, dist;

int modi(int idx)
{
	return idx%n;
}

int visitTrue(int idx, int i)
{
	int ret = dist[idx];
	int start = weak[i];
	for (int j = 0; j <= dist[idx]; ++j)
	{
		int cur = modi(start + j);
		if(visited[cur]==false)
			visited[cur] = true;
		else
		{
			ret = j - 1;
			break;
		}
	}
	return ret;
}

void visitFalse(int i, int cnt)
{
	int start = weak[i];
	for (int j = 0; j <= cnt; ++j)
	{
		int cur = modi(start + j);
		visited[cur] = false;
	}
}


bool chkAns()
{
	for (int i = 0; i < wlen; ++i)
	{
		if (visited[weak[i]] == false) return false;
	}
	return true;
}

void printArr()
{
	for (int i = 0;i < n; ++i)
	{
		cout << visited[i] << ' ';
	}
	cout << '\n';
}
int solve(int idx)
{
	if (chkAns()) return idx;
	if (idx == dlen) return BIG;
	int ret = BIG;
	for (int i = 0; i < wlen; ++i)
	{
		if (visited[weak[i]] == false)
		{

			int cnt = visitTrue(idx, i);
			ret = min(ret, solve(idx + 1));
			visitFalse(i, cnt);
		}	
	}
	return ret;
}

int solution(int _n, vector<int> _weak, vector<int> _dist) {
	n = _n;
	weak = _weak;
	dist = _dist;
	wlen = weak.size();
	dlen = dist.size();
	for (int i = 0; i < wlen; ++i)
		isWeak[i] = true;
	sort(dist.begin(), dist.end());
	reverse(dist.begin(), dist.end());
	int ans = solve(0);
	if (ans == BIG) ans = -1;
	return ans;
}

int main(void)
{
	cout << solution(12, { 1, 5, 6, 10 }, { 1, 2, 3, 4 });
}