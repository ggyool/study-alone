#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <cstring>
using namespace std;

int n,m;
int arr[1001][1001];
int dp[1001][1001];

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n >> m;
    for(int i=1; i<=n; ++i){
        for(int j=1; j<=m; ++j){
            cin >> arr[i][j];
        }
    }
    for(int i=1; i<=n; ++i){
        for(int j=1; j<=m; ++j){
            dp[i][j] = arr[i][j] + max(dp[i-1][j], dp[i][j-1]);
        }
    }
    cout << dp[n][m];
    return 0;
}

