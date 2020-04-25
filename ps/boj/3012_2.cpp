#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
using namespace std;


// 3012.cpp은 개구간으로 해서 초기화같은 것들이 까다로워서 if 들이 많이 들어갔다.
// 개폐구간으로 하면 구현이 편할듯 하여 만들어봄
// dp[x][x] = 1 초기화
typedef long long ll;
const int MOD = (int)1e6;
ll dp[202][202];
char arr[202];
int n;
string s;
char bracket[6] = {'(','[','{',')',']','}'};

int findIndex(char c){
    for(int i=0; i<6; ++i){
        if(c == bracket[i])
            return i;
    }
    return -1;
}

int isOpenIndex(int idx){
    if(idx<3) return true;
    return false;
}

int isCloseIndex(int idx){
    if(idx>=3) return true;
    return false;
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n;
    cin >> s;
    s = '.' + s;
    for(int i=1; i<=201; ++i){
        dp[i][i] = 1;
    }
    // i: 간격, j:left
    for(int i=2; i<=n; i+=2){
        for(int j=1; j+i<=n+1; j+=1){
            // j에 open, k-1은 close 여야함
            for(int k=j+2; k<=j+i; k+=2){
                int idx1 = findIndex(s[j]);
                int idx2 = findIndex(s[k-1]);
                if(idx1==-1 && idx2==-1){
                    dp[j][j+i] += 3* dp[j+1][k-1] * dp[k][j+i];
                    dp[j][j+i] %= MOD;
                }
                //둘 중 하나만 물음표
                else if( (idx1==-1 && isCloseIndex(idx2)) || (idx2==-1 && isOpenIndex(idx1))){
                    dp[j][j+i] += dp[j+1][k-1] * dp[k][j+i];
                    dp[j][j+i] %= MOD;
                }
                else if(idx1!=-1 && idx1+3==idx2){
                    dp[j][j+i] += dp[j+1][k-1] * dp[k][j+i];
                    dp[j][j+i] %= MOD;
                }
            }
        }
    }
    ll ans = dp[1][n+1];
    if(ans>=100000) {
        string ps = to_string(ans);
        int len = ps.size();
        for(int i=1; i<len; ++i){
            cout << ps[i];
        }   
    }
    else cout << ans;
    return 0;
}
