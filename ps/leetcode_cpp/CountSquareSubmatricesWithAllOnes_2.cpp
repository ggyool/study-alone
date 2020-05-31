#include <vector>
#include <algorithm>
#include <cstring>
#include <iostream>
using namespace std;

class Solution {
public:
    // i,j 를 오른쪽 아래 모서리로 가지는 square의 개수
    // 절묘하다.
    int dp[301][301];
    int countSquares(vector<vector<int>>& v) { 
        memset(dp, 0, sizeof(dp));
        int ret = 0;
        int c, r = v.size();
        if(r>0) c = v[0] .size();
        for(int i=0; i<r; ++i){
            for(int j=0; j<c; ++j){
                if(i==0 || j==0) {
                    dp[i][j] = (v[i][j]==1);
                }
                else {
                    if(v[i][j]==1)
                        dp[i][j] = min({dp[i-1][j-1], dp[i][j-1], dp[i-1][j]}) + 1;
                }
                ret += dp[i][j];
            }
        }
        return ret;
    }
};