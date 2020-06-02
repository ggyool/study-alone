#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

const int BIG = 987654321;
int n,k;
vector<int> v;
bool chk[10001]; 
int dp[10001];

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n >> k;
    int num;
    for(int i=0; i<n; ++i){
        cin >> num;
        if(num<=k) {
            chk[num] = true;
        }
    }
    dp[0] = 0;
    for(int i=1; i<=k; ++i){
        dp[i] = BIG;
        if(chk[i]){
            v.push_back(i);
        }
    }
    n = v.size();
    for(int i=1; i<=k; ++i){
        for(int j=0; j<n; ++j){
            int coin = v[j];
            if(i-coin>=0) {
                dp[i] = min(dp[i], 1 + dp[i-coin]);
            }
        }
    }
    if(dp[k] == BIG) cout << -1;
    else cout << dp[k];

    return 0;
}
