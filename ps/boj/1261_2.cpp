#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
#include <string>
#include <cstring>
using namespace std;

const int INF = (int)1e6;
const int dy[4] = {0,1,0,-1};
const int dx[4] = {1,0,-1,0};
int arr[100][100];
int dist[100][100];
int r,c;

struct Pos{
    int y, x;
    Pos(int _y, int _x)
    : y(_y), x(_x) {}
};

bool inRange(int y, int x){
    if(y<0 || x<0 || y>=r || x>=c) return false;
    return true;
}


// 처음 pq 쓴것과 발상은 비슷하지만 좀 더 발전
// 굳이 pq 쓸필요가 없다.
int solve(){
    memset(dist, -1, sizeof(dist));
    dist[0][0] = 0;
    deque<Pos> dq;
    dq.push_back(Pos(0,0));
    while(!dq.empty()){
        int cy = dq.front().y;
        int cx = dq.front().x;
        dq.pop_front();
        for(int i=0; i<4; ++i){
            int ny = cy + dy[i];
            int nx = cx + dx[i];
            if(!inRange(ny,nx)) continue;
            // dist[ny][nx] > dist[cy][cx] + ? 이런거 안해도 된다. 
            // 안 뿌시고 가는경우 먼저하게 만들어져 있다.
            if(dist[ny][nx] == -1){
                dist[ny][nx] = dist[cy][cx] + (arr[ny][nx]==1);
                if(arr[ny][nx]==0) dq.push_front(Pos(ny,nx));
                else dq.push_back(Pos(ny,nx));
            }
        }
    }
    return dist[r-1][c-1];
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> c >> r;
    for(int i=0; i<r; ++i){
        string s;
        cin >> s;
        for(int j=0; j<c; ++j){
            arr[i][j] = s[j] - '0';
        }
    }
    cout << solve();
    return 0;
}
