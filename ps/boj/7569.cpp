#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <string>
using namespace std;

struct Pos{
    int z, y, x;
    Pos(int _z, int _y, int _x){
        z = _z;
        y = _y;
        x = _x;
    }
};

const int dy[6] = {0,1,0,-1,0,0};
const int dx[6] = {1,0,-1,0,0,0};
const int dz[6] = {0,0,0,0,1,-1};
int n,m,h;
int arr[100][100][100];
int dist[100][100][100];
queue<Pos> q;

bool inRange(int z, int y, int x){
    if(y<0 || x<0 || z<0 || y>=n || x>=m || z>=h) return false;
    return true;
}

int bfs(){
    while(!q.empty()){
        int cz = q.front().z;
        int cy = q.front().y;
        int cx = q.front().x;
        q.pop();
        for(int i=0; i<6; ++i){
            int nz = cz + dz[i];
            int ny = cy + dy[i];
            int nx = cx + dx[i];
            if(inRange(nz,ny,nx) && arr[nz][ny][nx] == 0){
                arr[nz][ny][nx] = 1;
                dist[nz][ny][nx] = dist[cz][cy][cx] + 1;
                q.push(Pos(nz,ny,nx));
            }
        }
    }
    int ret = 0;
    for(int k=0; k<h; ++k){
        for(int i=0; i<n; ++i){
            for(int j=0; j<m; ++j){
                if(arr[k][i][j] == 0) return -1;
                ret = max(ret, dist[k][i][j]);
            }
        }
    }
    return ret;
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> m >> n >> h;
    for(int k=0; k<h; ++k){
        for(int i=0; i<n; ++i){
            for(int j=0; j<m; ++j){
                cin >> arr[k][i][j];
                if(arr[k][i][j] == 1){
                    q.push(Pos(k, i, j));
                }
            }
        }
    }
    
    cout << bfs();
    
    return 0;
}
