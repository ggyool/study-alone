#include <iostream>
using namespace std;

const int MOD = 10007;
int dp[1001][10];
int n;

int main(void){
    cin >> n;
    for(int i=0; i<=9; ++i)
        dp[1][i] = 1;

    for(int i=2; i<=n; ++i){
        for(int j=0; j<=9; ++j){
            for(int k=0; k<=j; ++k){
                dp[i][j] += dp[i-1][k]; 
                dp[i][j] %= MOD;
            }
        }
    }
    int ans = 0;
    for(int i=0; i<=9; ++i){
        ans += dp[n][i];
        ans %= MOD;
    }
    cout << ans;
    return 0;
}