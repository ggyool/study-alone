#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

struct Edge{
    int to, val;
    Edge(int _to=0, int _val=0) :to(_to), val(_val){}
};

int n,m;
int sta, fin;
vector<vector<Edge>> v;
vector<vector<Edge>> rv;
vector<int> ind;
vector<int> rind;
vector<int> longDist;

// ind 없으면 불가능, 다 보고 최대를 들고 감
int bfs(){
    queue<int> q;
    q.push(sta);
    longDist[sta] = 0;
    while(!q.empty()){
        int cur = q.front();
        q.pop();
        int len = v[cur].size();
        for(int i=0; i<len; ++i){
            int to = v[cur][i].to;
            int val = v[cur][i].val;
            longDist[to] = max(longDist[to], longDist[cur] + val);
            --ind[to];
            if(ind[to] == 0)
                q.push(to);
        }
    }
    return longDist[fin];
}

// 앞에서 부터 세도 될 것 같지만 중복되서 누적된다.
// 뒤에서 부터 봐야지 반드시 정답인 경로만 따라 갈 수있다.
int rbfs(){
    // 맞는 길일 때문 누적해야 한다.
    vector<bool> path(n+1, false);
    vector<int> cnt(n+1, 0);
    queue<int> q;
    q.push(fin);
    path[fin] = true;
    while(!q.empty()){
        int cur = q.front();
        q.pop();
        int len = rv[cur].size();
        for(int i=0; i<len; ++i){
            int to = rv[cur][i].to;
            int val = rv[cur][i].val;
            --rind[to];
            if(rind[to] == 0)
                q.push(to);
            if(longDist[cur] == longDist[to] + val && path[cur]){
                path[to] = true;
                cnt[to] += cnt[cur] + 1;
                // 중복하지 않는 포인트
                cnt[cur] = 0;
            }
        }
    }
    return cnt[sta];
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n >> m;
    v = vector<vector<Edge>> (n+1);
    rv = vector<vector<Edge>> (n+1);
    ind = vector<int>(n+1, 0);
    rind = vector<int>(n+1, 0);
    longDist = vector<int>(n+1, 0);

    for(int i=0; i<m; ++i){
        int a,b,c;
        cin >> a >> b >> c;
        v[a].push_back(Edge(b,c));
        rv[b].push_back(Edge(a,c));
        ++ind[b];
        ++rind[a];
    }
    cin >> sta >> fin;
    cout << bfs() << '\n'; 
    cout << rbfs() << '\n'; 
    
    return 0;
}
