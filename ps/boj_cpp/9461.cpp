#include <iostream>
#include <algorithm>
using namespace std;

typedef long long ll;

// long long 해야한다.
int n;
ll dp[101];

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int tc;
    cin >> tc;
    dp[1] = dp[2] = dp[3] = 1;
    for(int i=4; i<=100; i++){
        dp[i] = dp[i-2] + dp[i-3];
    }
    while(tc--){
        cin >> n;
        cout << dp[n] << '\n';
    }
    return 0;
}