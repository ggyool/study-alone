#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

// 접근
// 대칭인 경우가 아닌 쉬운 문제였다면
// d[n] = d[n-1] + d[n-2] + d[n-2]; 이다.
// 잘 생각해보면 좌우 대칭인 블럭인 항상 존재한다.
// 완전 좌우 대칭인 형태들은 한개만 존재 하므로
// 더해서 /2 한다.

int n;
int dp[31];

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n;
    dp[0] = dp[1] = 1;
    for(int i=2; i<=n; ++i){
        dp[i] = dp[i-1] + 2*dp[i-2];
    }    
    if(n==1) cout << dp[1];
    else if(n&1){
        // 홀수인 경우 가운데에 한 개 놓고 대칭 생각
        cout << (dp[n] + dp[n/2])/2;
    }
    else{
        // 짝수인 경우 반으로 쪼개진 경우, 가운데에 정사각형, 가운데에 가로 2개
        cout << (dp[n] + dp[n/2] + 2*dp[n/2-1])/2;
    }
    return 0;
}
