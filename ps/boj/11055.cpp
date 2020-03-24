#include <iostream>
using namespace std;

int n;
int dp[1001];
int arr[1001];

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n;
    for(int i=1; i<=n; ++i) 
        cin >> arr[i];

    dp[1] = arr[1];
    for(int i=2; i<=n; ++i){
        dp[i] = arr[i];
        for(int j=1; j<=i-1; ++j){
            if(arr[j] < arr[i])
                dp[i] = max(dp[i], dp[j]+arr[i]);
        }
    }
    int ans = 0;
    for(int i=1; i<=n; ++i)
        ans = max(ans, dp[i]);
    cout << ans;
    return 0;
}