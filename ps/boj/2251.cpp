#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <cstring>
using namespace std;

// a, c
bool visited[201][201];
int maxv[3];

void bfs(){
    int total = maxv[2];
    // a,c 물의 양
    queue<pair<int, int>> q;
    q.push({0, maxv[2]});
    visited[0][maxv[2]] = true;
    while(!q.empty()){
        int curv[3] = {0,0,0};
        int nextv[3] = {0,0,0};
        curv[0] = q.front().first;
        curv[2] = q.front().second;
        curv[1] = total - curv[0] - curv[2];
        q.pop();
        // i:from, j:to
        for(int i=0; i<3; ++i){
            for(int j=0; j<3; ++j){
                if(i==j) continue;
                nextv[j] = min(curv[j]+curv[i], maxv[j]); // j로 옮기고
                nextv[i] = curv[i] - (nextv[j]-curv[j]); // i에서 옮긴만큼 뺴고
                nextv[3-i-j] = curv[3-i-j]; // 나머지는 그대로
                if(visited[nextv[0]][nextv[2]] == false){
                    visited[nextv[0]][nextv[2]] = true;
                    q.push({nextv[0], nextv[2]});
                }
            }
        }
    }
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> maxv[0] >> maxv[1] >> maxv[2];
    bfs();
    for(int i=0; i<=maxv[2]; ++i){
        if(visited[0][i])
            cout << i << ' ';
    }
    return 0;
}
