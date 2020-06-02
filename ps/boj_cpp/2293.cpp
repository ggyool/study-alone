#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;


// i번째 동전까지 사용해서 j원을 만들 수 있는 경우의 수
// dp[i][j] = dp[i-1][j] + for(...) 지만 절묘하게 1차원으로 줄인다.
int dp[10001];
int n,k;
vector<int> v;

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n >> k;
    v = vector<int>(n);
    for(int i=0; i<n; ++i){
        cin >> v[i];
    }
    sort(v.begin(), v.end());
    dp[0] = 1;
    for(int i=0; i<n; ++i){
        int coin = v[i];
        for(int j=v[0]; j<=k; ++j){
            if(j-coin>=0) dp[j] += dp[j-coin];
        }        
    }
    cout << dp[k];
    return 0;
}
