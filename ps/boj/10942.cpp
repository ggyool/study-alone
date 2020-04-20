#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
using namespace std;

int n, m;
int arr[2001];
bool dp[2001][2001];

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n;
    for(int i=1; i<=n; ++i){
        cin >> arr[i];
        dp[i][i] = true;
        if(arr[i-1]==arr[i]) dp[i-1][i] = true;
    }
    for(int i=3; i<=n; ++i){
        for(int j=1; j+i-1<=n; ++j){
            if(arr[j] == arr[j+i-1] && dp[j+1][j+i-2]){
                dp[j][j+i-1] = true;
            }
        }
    }
    cin >> m;
    int a,b;
    for(int i=0; i<m; ++i){
        cin >> a >> b;
        cout << dp[a][b] << '\n';
    }
    return 0;
}

