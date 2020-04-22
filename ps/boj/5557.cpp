#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

typedef long long ll;

// 해당 i 까지 결과가 j 인 개수
ll dp[101][21];
int n;
int arr[101];

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n;
    for(int i=1; i<=n; ++i){
        cin >> arr[i];
    }
    // 처음 항에는 -를 넣을 수 없다.
    // 마지막은 = 이다.
    dp[0][0] = 1;
    for(int i=1; i<=n-1; ++i){
        int num = arr[i];
        for(int j=0; j<=20; ++j){
            // 더하기를 선택 하는 경우
            if(j+num<=20) dp[i][j+num] += dp[i-1][j];
            // 빼기를 선택 하는 경우
            if(i>1 && j-num>=0) dp[i][j-num] += dp[i-1][j];
        }
    }
    cout << dp[n-1][arr[n]];
    return 0;
}   
