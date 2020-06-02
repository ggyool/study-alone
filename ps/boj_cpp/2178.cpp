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
int arr[100][100];
int dist[100][100];
bool visited[100][100];


bool inRange(int y, int x){
    if(y<0 || x<0 || y>=n || x>=m) return false;
    return true;
}

int bfs(){
    queue<Pos> q;
    q.push(Pos(0,0));
    visited[0][0] = true;
    dist[0][0] = 1;
    while(!q.empty()){
        int cy = q.front().y;
        int cx = q.front().x;
        q.pop();
        for(int i=0; i<4; ++i){
            int ny = cy + dy[i];
            int nx = cx + dx[i];
            if(inRange(ny,nx) && !visited[ny][nx] && arr[ny][nx]){
                visited[ny][nx] = true;
                dist[ny][nx] = dist[cy][cx] + 1;
                q.push(Pos(ny,nx));
            }
        }
    }
    return dist[n-1][m-1];
}
int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    string s;
    cin >> n >> m;
    for(int i=0; i<n; ++i){
        cin >> s;
        for(int j=0; j<m; ++j){
            arr[i][j] = s[j] - '0';
        }
    }
    cout << bfs();
    
    return 0;
}
