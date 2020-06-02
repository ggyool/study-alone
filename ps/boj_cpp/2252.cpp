#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;

int n,m;
vector<vector<int>> v;
vector<int> ind;

void topoSort(){
    queue<int> q;
    for(int i=1; i<=n; ++i){
        if(ind[i]==0)
            q.push(i);
    }
    while(!q.empty()){
        int cur = q.front();
        cout << cur << ' ';
        q.pop();
        int len = v[cur].size();
        for(int i=0; i<len; ++i){
            int next = v[cur][i];
            --ind[next];
            if(ind[next] == 0){
                q.push(next);
            }
        }
    }
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n >> m;
    v = vector<vector<int>>(n+1);
    ind = vector<int>(n+1, 0);
    while(m--){
        int a,b;
        cin >> a >> b;
        v[a].push_back(b);
        ++ind[b];
    }
    topoSort();

    return 0;
}
