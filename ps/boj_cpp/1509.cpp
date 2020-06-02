#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
using namespace std;

int n;
string s;
bool isPalin[2500][2500];
int dp[2500];

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> s;
    n = s.size();
    for(int i=0; i<n; ++i){
        isPalin[i][i] = true;
        if(i>0 && s[i-1]==s[i]) isPalin[i-1][i] = true;
    }
    // i:글자간격
    for(int i=2; i<n; ++i){
        for(int j=0; j+i<n; ++j){
            if(s[j]==s[j+i] && isPalin[j+1][j+i-1]){
                isPalin[j][j+i] = true;
            }
        }
    }
    // i까지의 최소값
    dp[0] = 1;
    for(int i=1; i<n; ++i){
        //0~i-1  i~i
        dp[i] = dp[i-1]+1;
        if(isPalin[0][i]) {
            dp[i] = 1;
            continue;
        }
        // j: left
        for(int j=1; j<i; ++j){    
            if(isPalin[j][i]){
                dp[i] = min(dp[i], 1+dp[j-1]);
            } 
        }
    }
    cout << dp[n-1];
    return 0;
}
