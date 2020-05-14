#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

const int INF = 1000;
int dp[101][101];
int n,m;

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n >> m;
    for(int i=1; i<=n; ++i){
        for(int j=1; j<=n; ++j){
            if(i!=j) dp[i][j] = INF;
        }
    }    
    for(int i=0; i<m; ++i){
        int a,b;
        cin >> a >> b;
        dp[a][b] = 1;
        dp[b][a] = 1;
    }

    for(int k=1; k<=n; ++k){
        for(int i=1; i<=n; ++i){
            for(int j=1; j<=n; ++j){
                dp[i][j] = min(dp[i][j], dp[i][k] + dp[k][j]);
            }
        }
    }
    int bacon = INF;
    int ans;
    for(int i=1; i<=n; ++i){
        int sum = 0;
        for(int j=1; j<=n; ++j){
            if(i==j) continue;
            sum += dp[i][j];
        }
        if(bacon>sum){
            bacon = sum;
            ans = i;
        }
    }
    cout << ans;
    return 0;
}
