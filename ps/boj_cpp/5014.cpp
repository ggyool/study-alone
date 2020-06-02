#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <cstring>
using namespace std;

int dist[1000001];
int f,s,g,u,d;

bool inRange(int x){
    if(x<=0 || x>f) return false;
    return true;
}

int bfs(){
    memset(dist, -1, sizeof(dist));
    queue<int> q;
    q.push(s);
    dist[s] = 0;
    while(!q.empty()){
        int cur = q.front();
        if(cur==g) return dist[cur];
        q.pop();
        int next = cur + u;
        if(inRange(next) && dist[next] == -1){
            dist[next] = dist[cur] + 1;
            q.push(next);
        }
        next = cur - d;
        if(inRange(next) && dist[next] == -1){
            dist[next] = dist[cur] + 1;
            q.push(next);
        }
    }
    return -1;
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> f >> s >> g >> u >> d;
    int res = bfs();
    if(res==-1) cout << "use the stairs";
    else cout << res;
    return 0;
}
