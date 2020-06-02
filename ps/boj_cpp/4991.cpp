#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>
using namespace std;

const int dy[4] = {0,1,0,-1};
const int dx[4] = {1,0,-1,0};
const int BIG = 987654321;

struct Pos{
    int y,x;
    Pos(int _y, int _x)
        : y(_y), x(_x)
    {}
};

int oy,ox,oi;
int r,c;
// 방문해야 하는 노드
vector<Pos> pv;
int plen = 0;

char arr[20][20];

// i->j 가는 최단 경로
int nodeDist[10][10];

bool inRange(int y, int x){
    if(y<0 || x<0 || y>=r || x>=c) return false;
    return true;
}

void bfs(int f){
    int sy = pv[f].y;
    int sx = pv[f].x;
    queue<Pos> q;
    vector<vector<int>> dist = vector<vector<int>>(r, vector<int>(c, -1));
    dist[sy][sx] = 0;
    q.push(Pos(sy,sx));
    while(!q.empty()){
        int cy = q.front().y;
        int cx = q.front().x;
        q.pop();
        for(int i=0; i<4; ++i){
            int ny = cy + dy[i];
            int nx = cx + dx[i];
            if(!inRange(ny,nx) || dist[ny][nx]!=-1 || arr[ny][nx]=='x') continue;
            dist[ny][nx] = dist[cy][cx] + 1;
            q.push(Pos(ny,nx));
        }
    }
    for(int i=0; i<plen; ++i){
        if(i==f) continue;
        int ey = pv[i].y;
        int ex = pv[i].x;
        nodeDist[f][i] = dist[ey][ex];
    }
}

vector<int> v;
vector<bool> visited;

int pick(int cur, int pickn, int sum){
    if(pickn==plen) return sum;
    int ret = BIG;
    for(int i=0; i<plen; ++i){
        if(i==oi || visited[i]) continue;
        if(nodeDist[cur][i] == -1) return -1;
        visited[i] = true;
        ret = min(ret, pick(i, pickn+1, sum+nodeDist[cur][i]));
        visited[i] = false;
    }
    return ret;
}

// brute force
int solve(){
    int ret = BIG;
    visited = vector<bool>(plen, false);
    v.push_back(oi);
    visited[oi] = true;
    return pick(oi, 1, 0);
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    while(true){
        cin >> c >> r;
        plen = 0;
        pv.clear();
        if(c==0 && r==0) break;
        for(int i=0; i<r; ++i){
            for(int j=0; j<c; ++j){
                cin >> arr[i][j];
                if(arr[i][j]=='o' || arr[i][j]=='*'){
                    if(arr[i][j]=='o') oy=i, ox=j, oi=plen;
                    ++plen;
                    pv.push_back(Pos(i,j));
                }
            }
        }
        for(int i=0; i<plen; ++i){
            bfs(i);
        }
        cout << solve() << '\n';
    }
    return 0;
}