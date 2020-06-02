#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <cstring>
using namespace std;

int parent[101];

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
    for(int i=1; i<=n; ++i) parent[i] = i;
    while(m--){
        int a,b;
        cin >> a >> b;
        Union(a,b);
    }
    int ans = 0;
    int p = find(1);
    
    for(int i=2; i<=n; ++i){
        if(find(i)==p){
            ++ans;
        }
    }
    cout << ans;
    return 0;
}

