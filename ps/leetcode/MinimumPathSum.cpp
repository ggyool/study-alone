#include <deque>
#include <vector>
#include <string>
#include <algorithm>
#include <cstring>
using namespace std;

class Solution {
public:
    int minPathSum(vector<vector<int>>& grid) {
        int r = grid.size();
        if(r==0) return 0;
        int c = grid[0].size();
        vector<vector<int>> dp(r, vector<int>(c,0));
        dp[0][0] = grid[0][0];
        for(int j=1; j<c; ++j) {
            dp[0][j] = grid[0][j] + dp[0][j-1];
        }
        for(int i=1; i<r; ++i){
            dp[i][0] = grid[i][0] + dp[i-1][0];
            for(int j=1; j<c; ++j){
                dp[i][j] = grid[i][j] + min(dp[i][j-1], dp[i-1][j]);
            }
        }
        return dp[r-1][c-1];
    }
};