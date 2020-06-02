#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
using namespace std;

const int dy[4] = {0,1,0,-1};
const int dx[4] = {1,0,-1,0};
int n;
bool arr[25][25];
bool visited[25][25];
vector<int> v;

bool inRange(int y, int x){
    if(y<0 || y>=n || x<0 || x>=n) return false;
    return true;
}

int dfs(int y, int x){
    int ret = 1;
    for(int i=0; i<4; ++i){
        int ny = y + dy[i];
        int nx = x + dx[i];
        if(inRange(ny,nx) && arr[ny][nx] && !visited[ny][nx]){
            visited[ny][nx] = true;
            ret += dfs(ny, nx);
        }
    }
    return ret;
}

void dfsAll(){
    for(int i=0; i<n; ++i){
        for(int j=0; j<n; ++j){
            if(!visited[i][j] && arr[i][j]){
                visited[i][j] = true;
                v.push_back(dfs(i, j));
            }
        }
    }
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n;
    string s;
    for(int i=0;i<n; ++i){
        cin >> s;
        for(int j=0; j<n; ++j){
            arr[i][j] = (s[j] == '1');
        }
    }
    dfsAll();
    sort(v.begin(), v.end());
    int len = v.size();
    cout << len << '\n';
    for(int i=0; i<len; ++i){
        cout << v[i] << '\n';
    }

    
    return 0;
}