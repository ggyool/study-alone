#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int t,w;
int arr[1001];
int dp[31][1001];


int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> t >> w;
    for(int i=1; i<=t; ++i){
        cin >> arr[i];
    }
    // i: 이동횟수(홀수면 2, 짝수면 1에 있다), j:초
    for(int i=0; i<=w; ++i){
        for(int j=1; j<=t; ++j){
            if(i&1){
                dp[i][j] = max(dp[i][j],dp[i][j-1] + (arr[j]==2));
                if(i>0) dp[i][j] = max(dp[i][j], dp[i-1][j-1] + (arr[j]==2));
            }
            else{
                dp[i][j] = max(dp[i][j], dp[i][j-1] + (arr[j]==1));
                if(i>0) dp[i][j] = max(dp[i][j], dp[i-1][j-1] + (arr[j]==1));
            }
        }
    }
    int ans = 0;
    for(int i=0; i<=w; ++i){
        ans = max(ans, dp[i][t]);
    }
    cout << ans;
    return 0;
}
