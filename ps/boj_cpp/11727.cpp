#include <iostream>
using namespace std;

const int MOD = 10007;
int dp[1001];
int n;

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n;

    dp[1] = 1;
    dp[2] = 3;
    for(int i=3; i<=n; ++i){
        dp[i] = dp[i-1] + dp[i-2] * 2;
        dp[i] %= MOD;
    }
    cout << dp[n];
    return 0;
}