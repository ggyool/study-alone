#include <iostream>
#include <algorithm>
#include <vector>
#include <cstring>
using namespace std;

int arr[50][50];
bool visited[50][50];
int w,h;

bool inRange(int y, int x){
    if(y<0 || x<0 || y>=h || x>=w) return false;
    return true;
}

void dfs(int y, int x){
    for(int i=-1; i<=1; ++i){
        for(int j=-1; j<=1; ++j){
            int ny = y + i;
            int nx = x + j;
            if(inRange(ny,nx) && !visited[ny][nx] && arr[ny][nx]){
                visited[ny][nx] = true;
                dfs(ny,nx);
            }
        }
    }
}

int dfsAll(){
    memset(visited, false, sizeof(visited));
    int ret = 0;
    for(int i=0; i<h;++i){
        for(int j=0; j<w; ++j){
            if(!visited[i][j] && arr[i][j]){
                visited[i][j] = true;
                ++ret;
                dfs(i, j);
            }
        }
    }
    return ret;
}
int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    while(1){
        cin >> w >> h;
        if(w==0 || h==0) break;
        for(int i=0; i<h; ++i){
            for(int j=0; j<w; ++j){
                cin >> arr[i][j];
            }
        }
        cout << dfsAll() << '\n';
    }
    
    
    return 0;
}
