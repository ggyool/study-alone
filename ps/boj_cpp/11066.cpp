#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;


// knuth's optimization 라는것을 쓰면
// n**2 에도 풀 수 있다고 한다.

const int BIG = 987654321;
int t,n;
int v[501], psum[501];
int dp[501][501];

int calcPsum(int i, int j){
    return psum[j] - psum[i-1];
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> t;
    while(t--){
        cin >> n;
        psum[0] = 0;
        for(int i=1; i<=n; ++i){
            cin >> v[i];
            psum[i] = psum[i-1] + v[i];
            dp[i][i] = 0 ;
            dp[i-1][i] = v[i-1] + v[i];
        }
        // i: 간격, j:lef, k: 분할하는 위치
        for(int i=2; i<=n-1; ++i){
            for(int j=1; j+i<=n; ++j){
                dp[j][j+i] = BIG;
                for(int k=j; k<=j+i-1; ++k){
                    dp[j][j+i] = min(dp[j][j+i], calcPsum(j,j+i) + dp[j][k] + dp[k+1][j+i]);
                }
            }
        }   
        cout << dp[1][n] << '\n';
    }
    return 0;
}

a b c d e