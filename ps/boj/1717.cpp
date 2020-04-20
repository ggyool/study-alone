#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <cstring>
using namespace std;

int parent[1000001];

int find(int x){
    if(parent[x] == x) return x;
    return parent[x] = find(parent[x]);
}

void Union(int x, int y){
    x = find(x);
    y = find(y);
    parent[y] = find(x);    
}


int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int n,m;
    cin >> n >> m;
    for(int i=0; i<=n; ++i) parent[i] = i;
    while(m--){
        int cmd,a,b;
        cin >> cmd >> a >> b;
        if(cmd==0) Union(a,b);
        else{
            if(find(a)==find(b)) cout << "YES\n";
            else cout << "NO\n";
        }
    }
    return 0;
}

