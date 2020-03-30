#include <iostream>
#include <algorithm>
#include <queue>
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
int n;
int arr[100][100];
int gnd[100][100];
int dist[100][100];
queue<Pos> q;

bool inRange(int y, int x){
    if(y<0 || x<0 || y>=n || x>=n) return false;
    return true;
}

void bfs(int sty, int stx, int col){
    q.push(Pos(sty,stx));
    gnd[sty][stx] = col;
    while(!q.empty()){
        int cx = q.front().x;
        int cy = q.front().y;
        q.pop();
        for(int i=0; i<4; ++i){
            int ny = cy + dy[i];
            int nx = cx + dx[i];
            if(inRange(ny,nx) && arr[ny][nx] && gnd[ny][nx] == 0){
                gnd[ny][nx] = gnd[cy][cx];
                q.push(Pos(ny,nx));
            }
        }
    }
}

void bfsAll(){
    int col = 0;
    for(int i=0; i<n; ++i){
        for(int j=0; j<n; ++j){
            if(arr[i][j] && gnd[i][j] == 0){
                bfs(i, j, ++col);
            }
        }
    }
}


int bfsSolve(){
    queue<Pos> q;
    for(int i=0; i<n; ++i){
        for(int j=0; j<n; ++j){
            if(arr[i][j]) {
                q.push(Pos(i,j));
                dist[i][j] = 0;
            }
        }
    }

    int ret = 987654321;
    while(!q.empty()){
        int cx = q.front().x;
        int cy = q.front().y;
        q.pop();
        for(int i=0; i<4; ++i){
            int ny = cy + dy[i];
            int nx = cx + dx[i];
            if(inRange(ny,nx) && arr[ny][nx]==0){
                if(gnd[ny][nx] == 0){
                    dist[ny][nx] = dist[cy][cx] + 1;
                    gnd[ny][nx] = gnd[cy][cx];
                    q.push(Pos(ny,nx));
                }
                else if(gnd[ny][nx] != gnd[cy][cx]){
                    ret = min(ret, dist[ny][nx] + dist[cy][cx]);
                }
            }
        }
    }
    return ret;
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    
    cin >> n;
    
    for(int i=0; i<n; ++i){
        for(int j=0; j<n; ++j){
            cin >> arr[i][j];
        }
    }
    bfsAll(); // color
    cout << bfsSolve() << '\n';
    return 0;
}
