#include <iostream>
#include <algorithm>
using namespace std;

// 이 아이디어가 실버2인가

int n;
int dp[31];

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n;
    dp[0] = 1;
    dp[2] = 3;
    for(int i=4; i<=n; i+=2){
        dp[i] = 3*dp[i-2];
        for(int j=i-4; j>=0; j-=2){
            dp[i] += 2*dp[j];
        }
    }
    cout << dp[n];
    return 0;
}