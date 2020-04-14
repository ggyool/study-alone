#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <cstring>
using namespace std;

const int dy[4] = {0,1,0,-1};
const int dx[4] = {1,0,-1,0};
int r,c;
char arr[21][21];
bool alpha[26];
bool visited[20][20];

bool inRange(int y, int x){
    if(y<0 || x<0 || y>=r || x>=c) return false;
    return true;
}

int dfs(int y, int x){
    int ret = 1;
    for(int i=0; i<4; ++i){
        int ny = y + dy[i];
        int nx = x + dx[i];
        if(inRange(ny,nx) && !visited[ny][nx]){
            char c = arr[ny][nx];
            if(!alpha[c-'a']){
                visited[ny][nx] = true;
                alpha[c-'a'] = true;
                ret = max(ret, 1 + dfs(ny, nx));
                visited[ny][nx] = false;
                alpha[c-'a'] = false;
            }
        }
    }
    return ret;
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> r >> c;
    for(int i=0; i<r; ++i){
        cin >> arr[i];
    }
    visited[0][0] = true;
    alpha[arr[0][0]-'a'] = true;
    cout << dfs(0, 0);
    return 0;
}

