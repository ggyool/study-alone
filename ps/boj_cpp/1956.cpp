#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

const int INF = (int)1e8;
int n,m;
int dp[401][401];


int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n >> m;
    for(int i=1; i<=n; ++i){
        for(int j=1; j<=n; ++j){
            dp[i][j] = INF;
        }
    }
    for(int i=0; i<m; ++i){
        int a,b,c;
        cin >> a >> b >> c;
        dp[a][b] = min(dp[a][b], c);
    }

    for(int k=1; k<=n; ++k){
        for(int i=1; i<=n; ++i){
            for(int j=1; j<=n; ++j){
                dp[i][j] = min(dp[i][j], dp[i][k] + dp[k][j]);
            }
        }
    }
    int ans = INF;
    for(int i=1; i<=n; ++i){
        ans = min(ans, dp[i][i]);
    }
    if(ans==INF) cout << -1;
    else cout << ans;
    return 0;
}
