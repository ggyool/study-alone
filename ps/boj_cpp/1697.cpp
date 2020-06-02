#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
using namespace std;

typedef long long ll;
const int MAXN = 200001;
int n,x;
int dist[MAXN];
ll cnt[MAXN];

bool inRange(int x){
    if(x<0 || x>=MAXN) return false;
    return true;
}

void bfs(){
    queue<int> q;
    q.push(n);
    dist[n] = cnt[n] = 1;
    while(!q.empty()){
        int cur = q.front();
        q.pop();
        if(inRange(cur+1) && (dist[cur+1]==0 || dist[cur+1]-1==dist[cur])){
            if(dist[cur+1]==0) q.push(cur+1);
            dist[cur+1] = dist[cur] + 1;
            cnt[cur+1] += cnt[cur];
        }
        if(inRange(cur-1) && (dist[cur-1]==0 || dist[cur-1]-1==dist[cur])){
            if(dist[cur-1]==0) q.push(cur-1);
            dist[cur-1] = dist[cur] + 1;
            cnt[cur-1] += cnt[cur];
        }
        if(inRange(2*cur) && (dist[2*cur]==0 || dist[2*cur]-1==dist[cur])){
            if(dist[2*cur]==0) q.push(2*cur);
            dist[2*cur] = dist[cur] + 1;
            cnt[2*cur] += cnt[cur];
        }
    }
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n >> x;
    bfs();
    cout << dist[x] - 1 << '\n';
    cout << cnt[x]<< '\n';
    return 0;
}
