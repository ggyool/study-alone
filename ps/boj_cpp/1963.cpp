#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <cstring>
using namespace std;

bool isPrime[10000];
int dist[10000];

int bfs(int n, int m){
    memset(dist, -1, sizeof(dist));
    queue<int> q;
    q.push(n);
    dist[n] = 0;
    while(!q.empty()){
        int cur = q.front();
        if(cur==m) return dist[cur];
        q.pop();
        for(int j=1; j<=1000; j*=10){
            for(int i=0; i<=9; ++i){
                if(j==1000 && i==0) continue;
                int k = j*10;
                int next = (cur/k*k) + i*j + cur%j;
                if(isPrime[next] && dist[next]==-1){
                    dist[next] = dist[cur] + 1;
                    q.push(next);
                }
            }
        }
    }
    return -1;
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    memset(isPrime, 1, sizeof(isPrime));
    for(int i=2; i*i<10000; ++i){
        if(isPrime[i]){
            for(int j=2*i;j<10000; j+=i){
                isPrime[j] = false;
            }
        }
    }
    int tc;
    cin >> tc;
    while(tc--){
        int n, m;
        cin >> n >> m;
        cout <<bfs(n, m) << '\n';
    }
    return 0;
}
