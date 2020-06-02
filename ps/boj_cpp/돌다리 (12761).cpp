#include <iostream>
#include <queue>
#include <cstring>
using namespace std;


// n->m 최단경로
int a,b,n,m;
int dist[100001];

bool isGo(int pos)
{
    if( pos<0 || pos>100000) return false;
    if(dist[pos] != -1) return false;
    return true;
}

int bfs()
{
    memset(dist, -1 ,sizeof(dist));
    queue<int> q;
    q.push(n);
    dist[n] = 0;
    while(!q.empty())
    {
        int cur = q.front();
        if(cur==m) return dist[m];
        q.pop();
        int p;
        for(int i=0; i<3; ++i)
        {
            if(i==0) p = 1;
            else if(i==1) p = a;
            else p = b;
            if(isGo(cur+p))
            {
                dist[cur+p] = dist[cur] + 1;
                q.push(cur+p);
            }
            if(isGo(cur-p))
            {
                dist[cur-p] = dist[cur] + 1;
                q.push(cur-p);
            }
            if(i>0 && isGo(cur*p))
            {
                dist[cur*p] = dist[cur] + 1;
                q.push(cur*p);
            }
        }
    }
    return -1;
}


int main(void)
{
    cin >> a >> b >> n >> m;
    cout << bfs();
    return 0;
}