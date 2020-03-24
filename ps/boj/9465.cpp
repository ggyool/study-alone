#include <iostream>
using namespace std;

int tc, n;
int arr[2][100001];
int dp[2][100001];

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> tc;
    while(tc--){
        cin >> n;
        for(int i=1; i<=n; ++i) cin >> arr[0][i];
        for(int i=1; i<=n; ++i) cin >> arr[1][i];
        dp[0][1] = arr[0][1];
        dp[1][1] = arr[1][1];
        for(int i=2; i<=n; ++i){
            dp[0][i] = arr[0][i] + max(dp[1][i-1], dp[1][i-2]);
            dp[1][i] = arr[1][i] + max(dp[0][i-1], dp[0][i-2]);
        }
        cout << max(dp[0][n], dp[1][n]) << '\n';
    }
    return 0;
}