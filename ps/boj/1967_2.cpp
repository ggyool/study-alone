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
int maxDist;

// 핵심
// 경우의 수
// 1. 루트가 포함된 긴 한 가닥
// 2. 루트가 포함된 두가닥의 합
// 3. 자식 중 2가닥

// 해당 노드에서의 최대 길이
int dfs(int cur){
    int ret = 0;
    int len = v[cur].size();
    for(int i=0; i<len; ++i){
        int next = v[cur][i].to;
        int val = v[cur][i].val;
        if(!visited[next]){
            visited[next] = true;
            // 이전 기록과 현재 방문한 쪽을 더하면 위 경우의 수들을 커버할 수 있다.
            // 1. bef:0, cur: 최고길이
            // 2. bef: 한가닥, cur: 나머지 한가닥
            // 3. 모든 노드에 방문하므로 자식들에서 2번 작업을 하게된다.
            int bef = ret;
            int cur = val + dfs(next);
            maxDist = max(maxDist, bef + cur);
            ret = max(ret, cur);
        }
    }
    return ret;
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n;
    v = vector<vector<Node>> (n+1);
    visited = vector<bool> (n+1);
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
    cout << maxDist;
    return 0;
}
