#include <vector>
#include <algorithm>
#include <cstring>
#include <iostream>
using namespace std;

class Solution {
public:
    // y, x, 길이
    bool dp[301][301][301];
    int r, c;
    int countSquares(vector<vector<int>>& v) {
        int ret = 0;
        //memset(dp, false, sizeof(dp));
        r = v.size();
        if(r>0) c = v[0].size();
        for(int i=0; i<r; ++i){
            for(int j=0; j<c; ++j){
                dp[i][j][1] = (v[i][j]==1);
                if(dp[i][j][1]) ++ret;
            }
        }
        for(int s=2; s<=r; ++s){
            for(int i=0; i<=r-s; ++i){
                for(int j=0; j<=c-s; ++j){
                    dp[i+s-1][j+s-1][s] = (v[i+s-1][j+s-1]==1) && dp[i+s-2][j+s-1][s-1] && dp[i+s-1][j+s-2][s-1] && dp[i+s-2][j+s-2][s-1]; 
                    if(dp[i+s-1][j+s-1][s]){
                        ++ret;
                    }
                }
            }
        }
        return ret;
    }
};