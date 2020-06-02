#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;

int n,m;
vector<vector<int>> v;
vector<int> ind;

void topoSort(){
    // ind가 0인 문제들만 넣는다.
    priority_queue<int, vector<int>, greater<int>> pq;
    for(int i=1; i<=n; ++i){
        if(ind[i] == 0)
            pq.push(i);
    }
    while(!pq.empty()){
        int cur = pq.top();
        cout << cur << ' ';
        pq.pop();
        int len = v[cur].size();
        for(int i=0; i<len; ++i){
            int next = v[cur][i];
            --ind[next];
            if(ind[next] == 0)
                pq.push(next);
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
