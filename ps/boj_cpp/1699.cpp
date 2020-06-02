#include <iostream>
#include <algorithm>
using namespace std;

int n;
int dp[100001];
int arr[100001];

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n;
    dp[0] = 0;
    dp[1] = 1;
    for(int i=2; i<=n; ++i){
        // all 1**2
        dp[i]= i;
        for(int j=1; j*j<=i; ++j){
            dp[i] = min(dp[i], 1 + dp[i - j*j]);
        }
    }
    cout << dp[n];
    return 0;
}