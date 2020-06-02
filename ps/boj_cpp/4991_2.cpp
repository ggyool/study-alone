#include <iostream>
#include <vector>
#include <queue>
#include <cstring>
using namespace std; 

struct Pos{
    int y,x;
    Pos(int _y, int _x)
        :y(_y), x(_x){}
};

const int BIG = 987654321;
const int dy[4] = {0,1,0,-1};
const int dx[4] = {1,0,-1,0};
int r,c;
char arr[20][20];
int oIdx;
vector<Pos> pv;
int plen;
int shortDist[11][11];
int dp[11][1<<11];
vector<bool> visited;

bool inRange(int y, int x){
    if(y<0 || x<0 || y>=r || x>=c) return false;
    return true;
}

void bfs(int startIdx){
    vector<vector<int>> dist(r, vector<int>(c, -1));
    queue<Pos> q;
    q.push(pv[startIdx]);
    dist[pv[startIdx].y][pv[startIdx].x] = 0;
    while(!q.empty()){
        int cy = q.front().y;
        int cx = q.front().x;
        q.pop();
        for(int i=0; i<4; ++i){
            int ny = cy + dy[i];
            int nx = cx + dx[i];
            if(inRange(ny,nx) && arr[ny][nx]!='x' && dist[ny][nx]==-1){
                dist[ny][nx] = dist[cy][cx] + 1;
                q.push(Pos(ny,nx));
            }
        }
    }
    for(int i=0; i<plen; ++i){
        if(i==startIdx) continue;
        shortDist[startIdx][i] = dist[pv[i].y][pv[i].x];
    }
}

// bitmask, 역으로 돌아오는 dp
int pick(int bef, int history){
    if(history == (1<<plen)-1) return 0;
    if(dp[bef][history] != -1) return dp[bef][history];
    int &ret = dp[bef][history];
    ret = BIG;
    for(int i=0; i<plen; ++i){
        if(bef!=i && !visited[i] && shortDist[bef][i]!=-1){
            visited[i] = true;
            ret = min(ret, pick(i, history | (1<<i)) + shortDist[bef][i]);
            visited[i] = false;
        }
    }
    return ret;
}

int solve(){
    memset(dp, -1, sizeof(dp));
    visited = vector<bool>(plen, false);
    visited[oIdx] = true;
    int ans = pick(oIdx, 1<<oIdx);
    return ans==BIG?-1:ans;
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    while(true){
        cin >> c >> r;
        if(c+r==0) break;
        pv.clear();
        plen = 0;
        for(int i=0; i<r; ++i){
            for(int j=0; j<c; ++j){
                cin >> arr[i][j];
                if(arr[i][j] == 'o' || arr[i][j] == '*'){
                    if(arr[i][j] == 'o') oIdx = plen;
                    pv.push_back(Pos(i,j));
                    ++plen;
                }   
            }
        }
        plen = pv.size();
        for(int i=0; i<plen; ++i){
            bfs(i);
        }
        cout << solve() << '\n';
    }
    return 0;
}