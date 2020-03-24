#include <iostream>
#include <algorithm>
using namespace std;

const int MOD = (int)1e9;
int n, k;
// 1차원 배열 풀이
// i: val
int dp[201];

int main(void){ 
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n >> k;
    // k번 고르는 경우 셀 때까지 반복
    // i : pickn, j : val
    dp[0] = 1;
    for(int i=1; i<=k; ++i){
        for(int j=1; j<=n; ++j){
            if(i==1) dp[j] = 1;
            else{
                // dp[i][j] = dp[i-1][j] + dp[i][j-1]; 이 녹아있음 남아있는 dp[i-1][j] 사용
                dp[j] += dp[j-1];
                dp[j] %= MOD;
            }
        }
    }
    cout << dp[n];
    return 0;
}