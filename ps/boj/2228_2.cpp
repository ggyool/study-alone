#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

const int SMA = -987654321;
int n,m;
int arr[101];
int dp[101][51];
// 음수나 0도 나온다. dp배열을 범위 밖의 값으로 초기화해도 되지만
// check 배열만들었음
bool check[101][51];

// idx까지 pick 조각
int solve(int idx, int pick){
    if(pick==0) return 0;
    if(idx<1) return SMA;
    if(check[idx][pick]) return dp[idx][pick];
    check[idx][pick] = true;

    // 새로 추가된 idx를 선택하지 않는 경우
    dp[idx][pick] = solve(idx-1, pick);

    // 뒤에서 부터 누적시켜 psum 생략
    // i-2까지 pick-1조각, i~idx 까지 선택
    int sum = 0;
    for(int i=idx; i>=1; --i){
        sum += arr[i];
        dp[idx][pick] = max(dp[idx][pick], solve(i-2, pick-1) + sum);
    }
    return dp[idx][pick];
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >>n >> m;
    for(int i=1; i<=n; ++i){
        cin >> arr[i];
    }
    cout << solve(n,m);
    return 0;
}

