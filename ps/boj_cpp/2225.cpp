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
    // n<k 인 경우가 있다.
    for(int i=2; i<=k; ++i){
        // target value 
        for(int j=0; j<=n; ++j){
            // select value
            for(int k=0; k<=j; ++k){
                dp[i][j] += dp[i-1][j-k];
                dp[i][j] %= MOD;
            }
        }
    }
    cout << dp[k][n];
    return 0;
}