#include <iostream>
#include <vector>
#include <algorithm>
#include <cstring>
using namespace std;

const int MAX = 250000;

// i조각 까지 사용한 높이 차이 j, 값 높은 높이
int dp[51][MAX+1];
int arr[51];
int n;

// 합이 500000만이라고 하여
// 한 조각이 250000만 이하라고 생각하면 안된다.
// 400000 1 1 1 1 1 이런 케이스도 있다.

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n;
    for(int i=1; i<=n; ++i){
        cin >> arr[i];
    }   
    memset(dp, -1, sizeof(dp));
    dp[0][0] = 0;
    
    for(int i=1; i<=n; ++i){
        int h = arr[i];
        for(int j=0; j<=MAX; ++j){
            if(dp[i-1][j]>=0){
                //높은 쪽에 놓은 경우
                // 에러만 막아줘도 어차피 괜찮
                if(j+h<=MAX)
                    dp[i][j+h] = max(dp[i][j+h], dp[i-1][j] + h);
                // 낮은 쪽에 놓는데, 새로운 조각을 놓으면 높이 역전하는 경우
                if(h>=j){
                    if(h-j<=MAX)
                        dp[i][h-j] = max(dp[i][h-j], dp[i-1][j]-j+h);
                }
                else
                    dp[i][j-h] = max(dp[i][j-h], dp[i-1][j]);
                // 아무 것도 안 놓는 경우
                dp[i][j] = max(dp[i][j], dp[i-1][j]);      
            }
        }
    }
    if(dp[n][0] == 0) cout << -1;
    else cout << dp[n][0];
    return 0;
}
