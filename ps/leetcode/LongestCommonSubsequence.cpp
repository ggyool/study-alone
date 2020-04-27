#include <iostream>
#include <string>
#include <cstring>
#include <vector>
#include <algorithm>
#include <unordered_map>
using namespace std;

class Solution {
public:
    int dp[1001][1001];
    int longestCommonSubsequence(string text1, string text2) {
        memset(dp, 0, sizeof(dp));
        int sl1 = text1.size();
        int sl2 = text2.size();
        // text1 에서 i 까지 사용, text2에서 j 까지 사용
        for(int i=0; i<sl1; ++i){
            for(int j=0; j<sl2; ++j){
                
                if(j-1>=0) dp[i][j] = dp[i][j-1];
                if(i-1>=0) dp[i][j] = max(dp[i][j], dp[i-1][j]);
                if(text1[i] == text2[j]){
                    if(i>=1 && j>=1)
                        dp[i][j] = max(dp[i][j], dp[i-1][j-1] + 1);
                    else 
                        dp[i][j] = 1;
                }
            }
        }
        // for(int i=0; i<sl1; ++i){
        //     for(int j=0; j<sl2; ++j){
        //         cout << dp[i][j] << ' ';
        //     }
        //     cout << '\n';
        // }
        return dp[sl1-1][sl2-1];
    }
};

int main(void){
    Solution sol;
    sol.longestCommonSubsequence("abcde", "ace");
    /*
    a c e
    a 1 1 1
    b 1 1 1
    c 1 2 2
    d 1 2 2
    e 1 2 3
    */
}   