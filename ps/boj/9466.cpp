#include <iostream>
#include <algorithm>
#include <vector>
#include <cstring>
using namespace std;

// 하고 싶어서 그룹 없는 애들 더해나갔지만,
// 사이클을 구하고 토탈에서 빼는게 더 좋고.
// -1 넣어서 이전 dfs에 방문한지 체크 하는것보다
// 구역 나누는게 좋을듯 
int tc, n;
int arr[100001];
int dist[100001];

int dfs(int cur){
    int next = arr[cur];
    int ret = 0;
    // 이전 dfsAll에 방문
    if(dist[next]==-1){
        return dist[cur];
    }
    else if(dist[next] == 0){
        dist[next] = dist[cur] + 1;
        ret = dfs(next);
    }
    else{
        ret = dist[next]-1;
    }
    dist[next] = -1;
    return ret;
}

int dfsAll(){
    memset(dist, 0, sizeof(dist));
    int ret = 0;
    for(int i=1; i<=n; ++i){
        if(dist[i] == 0){
            dist[i] = 1;
            ret += dfs(i);
            dist[i] = -1;
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
        for(int i=1; i<=n;++i){
            cin >> arr[i];
        }
        cout << dfsAll() << '\n';
    }
    return 0;
}
