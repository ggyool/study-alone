#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

struct Node{
    int to, val;
    Node(int to, int val) : to(to), val(val){}
};

int n;
vector<vector<Node>> v;
vector<bool> visited;
vector<int> dist;
int maxDist;
int distNode;

void dfs(int cur){
    int len = v[cur].size();
    for(int i=0; i<len; ++i){
        int next = v[cur][i].to;
        int val = v[cur][i].val;
        if(!visited[next]){
            visited[next] = true;
            dist[next] = dist[cur] + val;
            if(maxDist<dist[next]){
                distNode = next;
                maxDist = dist[next];
            }
            dfs(next);
        }
    }
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n;
    v = vector<vector<Node>> (n+1);
    visited = vector<bool> (n+1);
    dist = vector<int> (n+1);
    for(int i=0; i<n; ++i){
        int a, to, val;
        cin >> a;
        while(true){
            cin >> to;
            if(to==-1) break;
            cin >> val;
            v[a].push_back(Node(to, val));
        }   
    }
    visited[1] = true;
    dfs(1);
    int tmp = distNode;
    visited = vector<bool> (n+1);
    dist = vector<int> (n+1);
    visited[tmp] = true;
    distNode = 0;
    maxDist = 0;
    dfs(tmp);
    cout << maxDist;
    return 0;
}
