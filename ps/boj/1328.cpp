#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

// 접근
// 1 2 , l=2 r=1
// 2 1 , l=1 r=2
// 에서 3을 놓는 경우
// 1 2 3 l+=1 r=1
// 1 3 2
// 3 1 2 l=1 r+=1
// 2 1 3 l+=1 r=1
// 2 3 1
// 3 2 1 l=1 r+=1
// 양 끝에 놓는 경우는 세기 쉬우나 중간 어딘가에 놓는 경우가 문제이다.

// 반대로 작은것을 추가한다고 생각하면 편해진다.
// 중간에 추가하는 경우 변화가 없다.
// 1 2 3  l=x, r=y
// 0 1 2 3 l+=1 r=y
// 1 2 3 0 l=x r+=1
// 1 0 2 3 변화x
// 1 2 0 3 변화x

typedef long long ll;
const int MOD = 1000000007;
int n,l,r;  
ll dp[101][101][101];

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n >> l >> r;
    dp[1][1][1] = 1;
    for(int i=1; i<=n-1; ++i){
        for(int j=1;j<=i; ++j){
            for(int k=1; k<=i; ++k){
                // 왼쪽에 놓는 경우
                dp[i+1][j+1][k] += dp[i][j][k];
                dp[i+1][j+1][k] %= MOD;
                // 오른쪽에 놓는 경우
                dp[i+1][j][k+1] += dp[i][j][k];
                dp[i+1][j][k+1] %= MOD;
                // 중앙에 놓는 경우
                dp[i+1][j][k] += (i-1)*dp[i][j][k];
                dp[i+1][j][k] %= MOD;
            }
        }
    }
    cout << dp[n][l][r];
    return 0;
}
