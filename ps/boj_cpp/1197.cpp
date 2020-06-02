#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

struct Edge{
    int from, to, val;
    Edge(int a=0, int b=0, int c=0){
        from = a;
        to = b;
        val = c;
    }
    bool operator<(const Edge &ref) const{
        return val < ref.val;
    }
};

int n,m;
vector<Edge> v;
vector<int> p;

int find(int x){
    if(x == p[x]) return x;
    return p[x] = find(p[x]);
}

void Union(int x, int y){
    x = find(x);
    y = find(y);
    p[y] = x;
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    
    cin >> n >> m;
    v = vector<Edge> (n+1);
    p = vector<int> (n+1);
    for(int i=1; i<=n; ++i){
        p[i] = i;
    }
    for(int i=0; i<m; ++i){
        int a,b,c;
        cin >> a >> b >> c;
        v.push_back(Edge(a,b,c));
    }
    sort(v.begin(), v.end());

    int ans = 0;
    int len = v.size();
    for(int i=0; i<len; ++i){
        int x = v[i].from;
        int y = v[i].to;
        int val = v[i].val;
        if(find(x) != find(y)){
            Union(x, y);
            ans += val;
        }
    }
    cout << ans;
    return 0;
}
