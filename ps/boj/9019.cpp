#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
using namespace std;

vector<int> from;
vector<char> cmd;

void bfs(int n, int m){
    from = vector<int>(10000, -1);
    cmd = vector<char> (10000);
    queue<int> q;
    q.push(n);
    from[n] = n;
    while(!q.empty()){
        int cur = q.front();
        if(cur==m) break;
        q.pop();
        int next;
        next = (2*cur)%10000;
        if(from[next]==-1){
            // cur 에서 cmd 연산으로 왔다.
            from[next] = cur;
            cmd[next] = 'D';
            q.push(next);
        }   
        next = (10000+cur-1)%10000;
        if(from[next]==-1){
            from[next] = cur;
            cmd[next] = 'S';
            q.push(next);
        }   
        next = (cur%1000)*10 + cur/1000;
        if(from[next]==-1){
            from[next] = cur;
            cmd[next] = 'L';
            q.push(next);
        }   
        next = (cur/10) + (cur%10)*1000;
        if(from[next]==-1){
            from[next] = cur;
            cmd[next] = 'R';
            q.push(next);
        }   
    }
}

void trace(int cur){
    if(cur==from[cur]) return;
    trace(from[cur]);
    cout << cmd[cur];
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int tc;
    cin >> tc;
    while(tc--){
        int n, m;
        cin >> n >> m;
        bfs(n, m);
        trace(m);
        cout << '\n';
    }
    return 0;
}
