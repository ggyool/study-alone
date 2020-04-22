#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int n,s,m;
// i번째 곡 j의 볼륨으로 연주 가능한지
bool dp[101][1001];
int arr[101];

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n >> s >> m;
    for(int i=1; i<=n; ++i){
        cin >> arr[i];
    }
    dp[0][s] = true;
    for(int i=1; i<=n; ++i){
        int vol = arr[i];
        for(int j=0; j<=m; ++j){
            if(dp[i-1][j]){
                if(j+vol<=m) dp[i][j+vol] = true;
                if(j-vol>=0) dp[i][j-vol] = true;
            }
        }
    }
    for(int i=m; i>=0; --i){
        if(dp[n][i]){
            cout << i;
            return 0;
        }
    }
    cout << -1;
    return 0;
}
