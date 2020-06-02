#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

struct Edge{
    int to, val;
    Edge(int _to=0, int _val=0) :to(_to), val(_val){}
};

int n,m;
int sta, fin;
vector<vector<Edge>> v;
vector<int> longDist;
vector<bool> visited;

int dfs(int cur){
    if(cur==fin) return 0;
    if(longDist[cur]>0) return longDist[cur];
    int len = v[cur].size();
    for(int i=0; i<len; ++i){
        int next = v[cur][i].to;
        int val = v[cur][i].val;
        longDist[cur] = max(longDist[cur], dfs(next)+val);
    }
    return longDist[cur];
}

int fdfs(int cur){
    int len = v[cur].size();
    int ret = 0;
    for(int i=0; i<len; ++i){
        int next = v[cur][i].to;
        int val = v[cur][i].val;
        
        if(longDist[cur]==longDist[next]+val){
            if(!visited[next]){
                visited[next] = true;
                ret += 1 + fdfs(next);
            }
            else{
                ret += 1;
            }
        }
    }
    return ret;
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n >> m;
    v = vector<vector<Edge>> (n+1);
    longDist = vector<int>(n+1, 0);
    visited = vector<bool>(n+1, false);

    for(int i=0; i<m; ++i){
        int a,b,c;
        cin >> a >> b >> c;
        v[a].push_back(Edge(b,c));
    }
    cin >> sta >> fin;
    cout << dfs(sta) << '\n'; 
    visited[sta] = true;
    cout << fdfs(sta);
    // for(int i=1; i<=n; ++i){
    //     cout << i << ':' << longDist[i] << '\n';
    // }
    return 0;
}
