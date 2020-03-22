#include <iostream>
#include <algorithm>
using namespace std;


int n;
int cost[1001];

// bot-up이 편하다.
// i장 카드를 모으기 위한 최대 비용
int dp[1001];

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n;
    for(int i=1; i<=n; ++i){
        cin >> cost[i];
    }
    // i:카드수, j: 카드팩번호
    for(int i=1; i<=n; ++i){
        for(int j=1; j<=i; ++j){
            dp[i] = max(dp[i], dp[i-j] + cost[j]);
        } 
    }
    cout << dp[n];
    return 0;
}