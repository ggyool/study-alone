#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

struct Edge{
    int from, to, val;
    Edge(int _from=0, int _to=0, int _val=0) : from(_from), to(_to), val(_val){}
    bool operator<(const Edge &ref) const{
        return val < ref.val;
    }
};

int n, m;
vector<Edge> v;
vector<int> p;

int find(int x){
    if(p[x] == x) return x;
    return p[x] = find(p[x]);
}

void Union(int x, int y){
    x = find(x);
    y = find(y);
    p[y] = x;
}



int kruskal(){
    int len = v.size();
    int ret = 0;
    for(int i=0; i<len; ++i){
        int from = v[i].from;
        int to = v[i].to;
        int val = v[i].val;
        int x = find(from);
        int y = find(to);
        if(x!=y){
            ret += val;
            Union(x,y);
        }
    }
    return ret;
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n >> m;
    v = vector<Edge>(n+1);
    p = vector<int>(n+1);
    for(int i=1; i<=n; ++i){
        p[i] = i;
    }
    for(int i=0; i<m; ++i){
        int a,b,c;
        cin >> a >> b >> c;
        v.push_back(Edge(a,b,c));   
    }
    sort(v.begin(), v.end());
    cout << kruskal();
    return 0;
}
