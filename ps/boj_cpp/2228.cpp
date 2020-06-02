#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

const int SMALL = -987654321;
int n,m;
int arr[101];
int psum[101];
// 1~i까지 j개 구간
int dp[101][51];

int calcPsum(int i, int j){
    return psum[j] - psum[i-1];
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n >> m;
    for(int i=0; i<=n; ++i){
        for(int j=0; j<=m; ++j){
            dp[i][j] = SMALL;
        }
    }
    for(int i=1; i<=n; ++i){
        cin >> arr[i];
        psum[i] = psum[i-1] + arr[i];
        dp[i][0] = 0;   
    }
    dp[1][1] = arr[1];
    // i번째 까지, j개 조각, k~i 까지 선택
    for(int i=2; i<=n; ++i){
        for(int j=1; j<=m; ++j){
            dp[i][j] = dp[i-1][j];
            for(int k=i; k>=1; --k){
                if(j-1==0) dp[i][j] = max(dp[i][j], calcPsum(k,i));
                if(k-2>=1)
                    dp[i][j] = max(dp[i][j], calcPsum(k, i) + dp[k-2][j-1]);
            }
        }
    }    
    int ans = SMALL;
    for(int i=1; i<=n; ++i){
        ans = max(ans, dp[i][m]);
    }
    cout << ans;
    return 0;
}
