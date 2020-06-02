#include <iostream>
#include <cstring>
using namespace std;

const int MOD = 1000000000;

// i: 길이, j: 마지막 숫자
int dp[101][10];
int n;

int dfs(int idx, int last){
    if(idx==n) return 1;
    
    int &ret = dp[idx][last];
    if(ret!=-1) return ret;
    ret = 0;
    if(last!=0)
        ret = dfs(idx+1, last-1);
    
    if(last!=9)
        ret += dfs(idx+1, last+1);
    ret %= MOD;
    // 삽질 많이 했다 ㅋㅋ 
    // return ret%MOD 하면 배열에 업데이트 안 됨
    return ret;
}

int main(void){
    memset(dp, -1, sizeof(dp));
    cin >> n;
    int ans = 0;
    for(int i=1; i<=9; ++i){
        ans += dfs(1, i);
        ans %= MOD;
    }
    cout << ans;
    return 0;
}
