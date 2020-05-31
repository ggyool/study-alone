#include <deque>
#include <vector>
#include <string>
#include <algorithm>
using namespace std;

class Solution {
public:
    bool checkValidString(string s) {
        vector<vector<bool>> dp(101, vector<bool>(101,false));
        return dfs(0, 0, s, dp);
    }

    bool dfs(int left, int idx, string &s, vector<vector<bool>> &dp){
        if(s.size()==idx) {
            if(left==0) return true;
            return false;
        }
        if(dp[left][idx]==true) return false;
        dp[left][idx] = true;        
        char c = s[idx];
        if(c=='('){
            return dfs(left+1, idx+1, s, dp);
        }
        else if(c==')'){
            if(left<=0) return false;
            return dfs(left-1, idx+1, s, dp);
        }
        else{
            bool ret = false;
            ret |= dfs(left+1, idx+1, s, dp);
            ret |= dfs(left, idx+1, s, dp);
            if(left>0) ret |= dfs(left-1, idx+1, s, dp);
            return ret;
        }
    }
};