#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
using namespace std;

// 일반적으로 반복문 돌려서 채워나가면 겹치는 것 떄문에 어렵다.
// 길이가 6인 경우
// 2 4 안에는 2 2 2가 들어있고
// 4 2 안에도 2 2 2가 들어있는 문제가 생긴다.
// 카탈란 수 점화식 유도하는 아이디어와 비슷하다고 한다.
// d[8] = ()*d[6] + (d[2])*d[4] + (d[4])*d[2] + (d[6])
// ()??????
// (??)????
// (????)??
// (??????)
// ??????()
// 5자리만 출력해야한다.
// 10????일때 0???? 이런식으로 출력해야 하기 때문에 %1e5하지 않고 1e6
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
    // i: 간격, j:left
    for(int i=1; i<=n-1; i+=2){
        for(int j=1; j+i<=n; j+=1){
            // j에 open, k에 close 여야함
            for(int k=j+1; k<=j+i; k+=2){
                int idx1 = findIndex(s[j]);
                int idx2 = findIndex(s[k]);
                ll val1, val2;
                if(idx1==-1 && idx2==-1){
                    val1 = j+1<k-1?dp[j+1][k-1]:1;
                    val2 = k+1<j+i?dp[k+1][j+i]:1;
                    dp[j][j+i] += 3* val1 * val2;
                    dp[j][j+i] %= MOD;
                }
                else if(idx1==-1 || idx2==-1){
                    // 둘 중 하나만 물음표
                    if(idx1==-1 && isCloseIndex(idx2)) {
                        val1 = j+1<k-1?dp[j+1][k-1]:1;
                        val2 = k+1<j+i?dp[k+1][j+i]:1;
                        dp[j][j+i] += val1*val2;
                        dp[j][j+i] %= MOD;   
                    }
                    if(idx2==-1 && isOpenIndex(idx1)){
                        val1 = j+1<k-1?dp[j+1][k-1]:1;
                        val2 = k+1<j+i?dp[k+1][j+i]:1;
                        dp[j][j+i] += val1*val2;
                        dp[j][j+i] %= MOD;
                    }
                }
                else if(idx1+3==idx2){
                    val1 = j+1<k-1?dp[j+1][k-1]:1;
                    val2 = k+1<j+i?dp[k+1][j+i]:1;
                    dp[j][j+i] += val1*val2;
                    dp[j][j+i] %= MOD;
                }
            }
        }
    }
    ll ans = dp[1][n];
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
