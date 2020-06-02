 #include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <cstring>
using namespace std;

typedef long long ll;
const int MAXN = 200001;
int n,x;
int dist[MAXN];
int from[MAXN];

bool inRange(int x){
    if(x<0 || x>=MAXN) return false;
    return true;
}

void bfs(){
    memset(dist, -1, sizeof(dist));
    queue<int> q;
    q.push(n);
    dist[n] = 0;
    while(!q.empty()){
        int cur = q.front();
        q.pop();
        if(inRange(cur+1) && dist[cur+1]==-1){
            dist[cur+1] = dist[cur] + 1;
            from[cur+1] = cur;
            q.push(cur+1);
        }
        if(inRange(cur-1) && dist[cur-1]==-1){
            dist[cur-1] = dist[cur] + 1;
            from[cur-1] = cur;
            q.push(cur-1);
        }
        if(inRange(cur*2) && dist[cur*2]==-1){
            dist[cur*2] = dist[cur] + 1;
            from[cur*2] = cur;
            q.push(cur*2);
        }
    }
}

void trace(int cur){
    if(cur==n) {
        cout << cur << ' ';
        return;
    }
    trace(from[cur]);
    cout << cur << ' ';
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n >> x;
    bfs();
    cout << dist[x] << '\n';
    trace(x);
    return 0;
}
