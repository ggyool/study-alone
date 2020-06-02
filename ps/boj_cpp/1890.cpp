#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <cstring>
using namespace std;

typedef long long ll;
int n;
int arr[101][101];
ll dp[101][101];

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n;
    for(int i=1; i<=n; ++i){
        for(int j=1; j<=n; ++j){
            cin >> arr[i][j];
        }
    }
    dp[1][1] = 1;
    for(int i=1; i<=n; ++i){
        for(int j=1; j<=n; ++j){
            if(arr[i][j]==0) continue;
            if(i+arr[i][j]<=n) {
                dp[i+arr[i][j]][j] += dp[i][j];
            }
            if(j+arr[i][j]<=n){
                dp[i][j+arr[i][j]] += dp[i][j];
            }
        }
    }
    cout << dp[n][n];
    return 0;
}

