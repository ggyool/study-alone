#include <iostream>
#include <algorithm>
using namespace std;

int n;
int dp[10001];
int arr[10001];

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n;
    for(int i=1; i<=n; ++i)
        cin >> arr[i];
    dp[1] = arr[1];
    dp[2] = arr[1] + arr[2];
    for(int i=3; i<=n; ++i){
        dp[i] = arr[i] + arr[i-1] + dp[i-3];
        dp[i] = max(dp[i], arr[i] + dp[i-2]);
    }   
    cout << dp[n];
    return 0;
}