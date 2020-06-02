#include <iostream>
#include <algorithm>
#include <vector>
#include <cstring>
using namespace std;

// 순열이므로 outdegree, indegree 가 한개씩이라는게 포인트
// 그냥 컴포넌트 개수 세면 된다.
int tc, n;
int arr[1001];
int visited[1001];

void dfs(int cur){
    int next = arr[cur];
    if(!visited[next]){
        visited[next] = true;
        dfs(next);
    }
}

int dfsAll(){
    memset(visited, false, sizeof(visited));
    int ret = 0;
    for(int i=1; i<=n; ++i){
        if(!visited[i]){
            ++ret;
            visited[i] = true;
            dfs(i);
        }
    }
    return ret;
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    cin >> tc;
    while(tc--){
        cin >> n;
        for(int i=1; i<=n; ++i){
            int num;
            cin >> num;
            arr[i] = num;
        }
        cout << dfsAll() << '\n';
    }

    
    return 0;
}
