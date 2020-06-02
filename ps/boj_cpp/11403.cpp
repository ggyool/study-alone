#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int arr[101][101];
bool dp[101][101];
int n;

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n;
    for(int i=1; i<=n; ++i){
        for(int j=1; j<=n; ++j){
            cin >> arr[i][j];
            dp[i][j] = arr[i][j];
        }
    }
    for(int k=1; k<=n; ++k){
        for(int i=1; i<=n; ++i){
            for(int j=1; j<=n; ++j){
                dp[i][j] = dp[i][j] | (dp[i][k] & dp[k][j]);
            }
        }
    }
    for(int i=1; i<=n; ++i){
        for(int j=1; j<=n; ++j){
            cout << dp[i][j] << ' ';
        }
        cout << '\n';
    }

    return 0;
}
