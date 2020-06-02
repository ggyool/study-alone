#include <iostream>
using namespace std;

typedef long long ll;
int n;
ll dp[91];

int main(void){
    cin >> n;
    dp[1] = 1;
    for(int i=2; i<=n; ++i){
        //      last 0    last 1
        dp[i] = dp[i-1] + dp[i-2];
    }
    cout << dp[n];
    return 0;
}