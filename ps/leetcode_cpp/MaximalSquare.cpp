#include <vector>
#include <algorithm>
#include <iostream>
using namespace std;


class Solution {
public:
    int r,c;
    vector<vector<int>> dp;
    int maximalSquare(vector<vector<char>>& v) {
        int ret = 0;
        r = v.size();
        if(r>0) c = v[0].size();
        // i,j 를 포함한 최대 square 크기
        dp = vector<vector<int>>(r, vector<int>(c, 0));
        for(int i=0; i<r; ++i){
            for(int j=0; j<c; ++j){
                if(i==0 || j==0) {
                    if(v[i][j] == '1'){
                        dp[i][j] = 1;
                        ret = max(ret, dp[i][j]);
                    }
                }
                else if(v[i][j] == '1'){
                    int s = min(dp[i][j-1], dp[i-1][j]);
                    if(v[i-s][j-s] == '1'){
                        dp[i][j] = s+1;
                        ret = max(ret, dp[i][j]);
                    } 
                    else{
                        dp[i][j] = s;
                    }
                }
            }
        }
        return ret*ret;
    }
};

int main(void){

    Solution sol;
    vector<vector<char>> v = {
        {'1','0','1','0','0'},
        {'1','0','1','1','1'},
        {'1','1','1','1','1'},
        {'1','0','0','1','0'}};
    cout << sol.maximalSquare(v);
    
}