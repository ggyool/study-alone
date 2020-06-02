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
    for(int i=1; i<=n; ++i)
        cin >> arr[i];
    dp[1] = arr[1];
    for(int i=2; i<=n; ++i)
        dp[i] = max(arr[i], dp[i-1] + arr[i]);
    
    // 음수가 정답인 경우 때문에 0으로 초기화하면 안 됨
    int ans = -987654321;
    for(int i=1; i<=n; ++i)
        ans = max(ans, dp[i]);
    cout << ans;
    return 0;
}