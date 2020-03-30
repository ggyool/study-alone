#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <string>
using namespace std;

struct Pos{
    int y, x;
    Pos(int _y, int _x){
        y = _y;
        x = _x;
    }
};

const int dy[4] = {0,1,0,-1};
const int dx[4] = {1,0,-1,0};
int n,m;
int arr[1000][1000];
int dist[1000][1000];
queue<Pos> q;

bool inRange(int y, int x){
    if(y<0 || x<0 || y>=n || x>=m) return false;
    return true;
}

int bfs(){
    while(!q.empty()){
        int cy = q.front().y;
        int cx = q.front().x;
        q.pop();
        for(int i=0; i<4; ++i){
            int ny = cy + dy[i];
            int nx = cx + dx[i];
            if(inRange(ny,nx) && arr[ny][nx] == 0){
                arr[ny][nx] = 1;
                dist[ny][nx] = dist[cy][cx] + 1;
                q.push(Pos(ny,nx));
            }
        }
    }
    int ret = 0;
    for(int i=0; i<n; ++i){
        for(int j=0; j<m; ++j){
            if(arr[i][j] == 0) return -1;
            ret = max(ret, dist[i][j]);
        }
    }
    return ret;
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> m >> n;
    for(int i=0; i<n; ++i){
        for(int j=0; j<m; ++j){
            cin >> arr[i][j];
            if(arr[i][j] == 1){
                q.push(Pos(i, j));
            }
        }
    }
    cout << bfs();
    
    return 0;
}
