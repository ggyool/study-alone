#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

// 대칭 점화식을 직접 구해서 푼 경우
// 양쪽에 1개짜리 추가 한 경우 + 2개짜리 추가한 경우
// mir[i] = mir[i-2] + 2*mir[i-4]
int n;
int dp[31];
int mir[31];

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n;
    dp[0] = dp[1] = 1;
    for(int i=2; i<=n; ++i){
        dp[i] = dp[i-1] + 2*dp[i-2];
    }    
    mir[0] = 1;
    mir[1] = 1;
    mir[2] = 3;
    mir[3] = 1;
    for(int i=4; i<=n; ++i){
        mir[i] = mir[i-2] + 2*mir[i-4];
    }
    cout << (dp[n] + mir[n])/2;
    return 0;
}
