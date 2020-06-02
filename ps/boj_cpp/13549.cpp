 #include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <cstring>
using namespace std;

typedef long long ll;
const int MAXN = 200001;
const int dx[2] = {-1, 1};
int n,x;
int dist[MAXN];

bool inRange(int x){
    if(x<0 || x>=MAXN) return false;
    return true;
}

void bfs(){
    memset(dist, -1, sizeof(dist));
    queue<int> q;
    queue<int> tq;
    q.push(n);
    dist[n] = 0;
    while(!q.empty()){
        tq = q;
        while(!tq.empty()){
            int cur = tq.front();
            tq.pop();
            if(inRange(2*cur) && dist[2*cur]==-1){
                dist[2*cur] = dist[cur];
                q.push(2*cur);
                tq.push(2*cur);
            }
        }
        int len = q.size();
        for(int i=0;i<len; ++i){
            int cur = q.front();
            q.pop();
            for(int d=0; d<2; ++d){
                int next = cur + dx[d];
                if(inRange(next) && dist[next]==-1){
                    dist[next] = dist[cur] + 1;
                    q.push(next);
                }
            }
        }
    }
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n >> x;
    bfs();
    cout << dist[x] << '\n';
    return 0;
}
