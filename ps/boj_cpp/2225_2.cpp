#include <iostream>
#include <algorithm>
using namespace std;

const int MOD = (int)1e9;
int n, k;
// i:count, j:val
int dp[201][201];

int main(void){ 
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n >> k;
    for(int i=0; i<=n; ++i){
        dp[1][i] = 1;
    }
    for(int i=2; i<=k; ++i){
        dp[i][0] = 1;
        for(int j=1; j<=n; ++j){
            // dp[i][j] = dp[i-1][j] + dp[i-1][j-1] + dp[i-1][j-2] + dp[i-1][j-3] ..... 해야하나
            // dp[i-1][j-1] + dp[i-1][j-2] + dp[i-1][j-3]  ---> dp[i][j-1] 이다... 테이블 그려보면 보인다.
            dp[i][j] = dp[i-1][j] + dp[i][j-1];
            dp[i][j] %= MOD;
        }
    }
    cout << dp[k][n];
    return 0;
}