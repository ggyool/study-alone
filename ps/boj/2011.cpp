#include <iostream>
#include <algorithm>
#include <string>
using namespace std;


const int MOD = (int)1e6;
int n;
int dp[5001];
string s;

bool isAble(int idx){
    char bef = s[idx-1];
    char cur = s[idx];
    if(bef=='1'){
        return true;
    }
    if(bef=='2'){
        if(cur <= '6') return true;
    }
    return false;
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> s;
    n = s.size();
    if(s[0] == '0') {
        cout << 0;
        return 0;
    }
    dp[0] = 1;
    for(int i=1; i<n; ++i){
        // 금방 찾았다.
        if(s[i]!='0') dp[i] += dp[i-1];
        if(isAble(i)){
            if(i==1) dp[i] += 1;
            else dp[i] += dp[i-2];
        }
        dp[i] %= MOD;       
    }
    cout << dp[n-1];
    return 0;
}