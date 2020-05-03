#include <vector>
#include <algorithm>
#include <iostream>
using namespace std;


class Solution {
public:
    int r,c;
    vector<int> dp;
    int maximalSquare(vector<vector<char>>& v) {
        int ret = 0;
        r = v.size();
        if(r>0) c = v[0].size();
        // 일부러 idx+1 로 잡음
        //dp = vector<vector<int>>(r+1, vector<int>(c+1, 0));
        // 재활용하여 1차원 공간 사용
        dp = vector<int> (max(r,c)+1, 0);
        int prev;
        for(int i=1; i<=r; ++i){
            for(int j=1; j<=c; ++j){
                int tmp = dp[j];
                if(v[i-1][j-1]=='1'){
                    dp[j] = min(prev, min(dp[j-1], dp[j])) + 1;
                    ret = max(ret, dp[j]);
                }
                else{
                    dp[j] = 0;
                }
                prev = tmp;
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