#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
#define PILLAR 0
#define  BEAM 1
#define CREATE 1
#define DELETE 0
using namespace std;

// 시계방향으로 90도 돌려서 왼쪽위 0,0 으로

struct Pos
{
	bool isPillar, isBeam;
	Pos()
	{
		isPillar = isBeam = false;
	}
};

class Handle
{
public:
	Pos** town;
	int n;
	Handle(int _n = 0)
	{
		n = _n;
		town = new Pos*[n+1];
		for (int i = 0; i <= n; ++i)
		{
			town[i] = new Pos[n+1];
		}
	}
	~Handle()
	{
		for (int i = 0; i <= n;++i)
		{
			delete[] town[i];
		}
		delete[] town;
	}
	bool inRange(int y, int x)
	{
		if (y<0 || x<0 || y>n || x>n) return false;
		return true;
	}
	bool isPillar(int y, int x)
	{
		return town[y][x].isPillar;
	}
	bool isBeam(int y, int x)
	{
		return town[y][x].isBeam;
	}
	bool canBuild(int y, int x, int kind)
	{
		if (kind == PILLAR)
		{
			// 이미 기둥
			if (isPillar(y, x)) return false;
			// 바닥 or 왼기둥 or 위보 or 아래보
			if (x == 0) return true;
			if (isPillar(y, x-1)) return true;
			if (inRange(y-1, x) && isBeam(y-1, x))return true;
			if (isBeam(y, x)) return true;
		}
		else if (kind == BEAM)
		{
			if (isBeam(y, x)) return false;
			// 하나라도 기둥
			if (inRange(y, x - 1) && isPillar(y, x - 1)) return true;
			if(inRange(y + 1, x-1) && isPillar(y + 1,x-1)) return true;
			// 양쪽 보
			if (inRange(y - 1, x) && isBeam(y - 1, x))
			{
				if (inRange(y + 1, x) && isBeam(y + 1, x)) return true;
			}
		}
		return false;
	}
	void build(int y, int x, int kind)
	{
		if (kind == PILLAR) town[y][x].isPillar = true;
		else if(kind == BEAM) town[y][x].isBeam = true;
	}
	bool isOkay(int y, int x)
	{
		bool ret1 = false;
		bool ret2 = false;
		if (isBeam(y, x))
		{
			if (inRange(y, x - 1) && isPillar(y, x - 1)) ret1 |= true;
			if (inRange(y + 1, x - 1) && isPillar(y + 1, x - 1)) ret1 |= true;
			if (inRange(y - 1, x) && inRange(y + 1, x))
			{
				if (isBeam(y - 1, x) && isBeam(y + 1, x)) ret1 |= true;
			}
		}
		else ret1 = true;
		if (isPillar(y, x))
		{
			if (x == 0) ret2 |= true;
			if (inRange(y, x-1) && isPillar(y, x - 1)) ret2 |= true;
			if (inRange(y - 1, x) && isBeam(y - 1, x)) ret2 |= true;
			if (isBeam(y, x)) ret2 |= true;
		}
		else ret2 = true;
		return ret1 && ret2;
	}
	bool isAllRight(int y, int x, int kind)
	{
		if (kind == PILLAR)
		{
			// 기둥을 삭제하는 경우 문제가 없다면
			int dy[2] = { -1,0 };
			int dx[2] = {1,1};
			for(int i=0; i<2; ++i)
			{
				int ny = y + dy[i];
				int nx = x + dx[i];
				if (inRange(ny,nx) && !isOkay(ny, nx)) return false;
			}
		}
		else if (kind == BEAM)
		{
			int dy[3] = {-1,0,1};
			int dx[3] = {0, 0,0};
			for (int i = 0; i < 3; ++i)
			{
				int ny = y + dy[i];
				int nx = x + dx[i];
				if (inRange(ny, nx) && !isOkay(ny, nx)) return false;
			}
		}
		return true;
	}
	void erase(int y, int x, int kind)
	{
		if (kind == BEAM) town[y][x].isBeam = false;
		if (kind == PILLAR) town[y][x].isPillar = false;
	}
};



int bflen;

vector<vector<int>> solution(int n, vector<vector<int>> bf) {
	Handle h = Handle(n);
	bflen = bf.size();
	vector<vector<int>> ret;

	for (int i = 0; i < bflen; ++i)
	{
		
		int y = bf[i][0];
		int x = bf[i][1];
		int kindOf = bf[i][2];
		int comm = bf[i][3];
	
		if (comm == CREATE)
		{
			if (h.canBuild(y, x, kindOf))
			{
				h.build(y, x, kindOf);
			}
		}
		else if (comm == DELETE)
		{
			
			if (kindOf == PILLAR && !h.isPillar(y, x)) continue;
			if (kindOf == BEAM && !h.isBeam(y, x)) continue;
			h.erase(y, x, kindOf);
			if (!h.isAllRight(y, x, kindOf))
			{
				//cout << y << "  " << x << "  " << kindOf << "  " << comm << '\n';
				h.build(y, x, kindOf);
			}
		}
	}

	for (int i = 0; i <= n; ++i)
	{
		for (int j = 0; j <= n; ++j)
		{
			if (h.town[i][j].isPillar) ret.push_back({i,j,PILLAR});
			if (h.town[i][j].isBeam) ret.push_back({ i,j,BEAM });
		}
	}
	sort(ret.begin(), ret.end());
	return ret;
}

int main(void)
{
	vector < vector<int>> v = solution(5, { { 0, 0, 0, 1 },{ 2, 0, 0, 1 },{ 4, 0, 0, 1 },{ 0, 1, 1, 1 },{ 1, 1, 1, 1 },{ 2, 1, 1, 1 },{ 3, 1, 1, 1 },{ 2, 0, 0, 0 },{ 1, 1, 1, 0 },{ 2, 2, 0, 1 } });
	
	return 0;
}