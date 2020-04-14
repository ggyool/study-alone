#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <cstring>
using namespace std;

struct Node{
    int to, weight;
    Node(int a, int b) : to(a), weight(b){}
};

int n,m,s,e;
vector<vector<Node>> v;
bool visited[10001];

bool isAble(int val){
    memset(visited, false, sizeof(visited));    
    queue<int> q;
    q.push(s);
    visited[s] = true;
    while(!q.empty()){
        int cur = q.front();
        if(cur==e) return true;
        q.pop();
        int len = v[cur].size();
        for(int i=0; i<len; ++i){
            int next = v[cur][i].to;
            int w = v[cur][i].weight;
            if(!visited[next] && w>=val){
                visited[next] = true;
                q.push(next);
            }
        }
    }
    return false;
}

int solve(){
    int left = 1;
    int right = (int)1e9;
    int mid;
    int ret = 0;
    while(left<=right){
        mid = left + (right-left)/2;
        if(isAble(mid)){
            left = mid + 1;
            ret = max(ret, mid);
        }
        else{
            right = mid - 1;
        }
    }
    return ret;
}
int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n >> m;
    v = vector<vector<Node>> (n+1);
    for(int i=0; i<m; ++i){
        int a,b,c;
        cin >> a >> b >> c;
        v[a].push_back(Node(b,c));
        v[b].push_back(Node(a,c));
    }
    cin >> s >> e;
    cout << solve();
    return 0;
}

