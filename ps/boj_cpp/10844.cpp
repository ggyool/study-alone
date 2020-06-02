#include <iostream>
using namespace std;

const int MOD = 1e9;

// i: 길이, j: 마지막 숫자
int dp[101][10];
int n;

int main(void){
    cin >> n;
    for(int i=1; i<=9; ++i){
        dp[1][i] = 1;
    }
    
    for(int i=2; i<=n; ++i){
        for(int j=0; j<=9; ++j){
            if(j!=9) dp[i][j] += dp[i-1][j+1];
            if(j!=0) dp[i][j] += dp[i-1][j-1];
            dp[i][j] %= MOD;
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
