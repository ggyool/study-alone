#include <iostream>
#include <string>
#include <cstring>
#include <algorithm>
#include <vector>
using namespace std;

// 처음 접근 보고 푼 풀이
// 깔끔하게 자바로 다시 품
class Solution {
public:
    const int INF = (int)1e9;
    vector<vector<int>> dp;
    int n,m ;
    int threeMin(int x, int y, int z){
        return min(min(x, y), z); 
    } 
    int solve(string &sa, string &sb, int i, int j){
        if(i==n && j==m) return 0;
        if(i>n || j>m) return INF;
        if(sa[i] == sb[j]){
            return solve(sa, sb, i+1, j+1);
        }
        if(dp[i][j]!=-1) return dp[i][j];
        return dp[i][j] = 1 + threeMin(solve(sa,sb,i+1,j), // delete
                 solve(sa,sb,i,j+1), // insert
                 solve(sa,sb,i+1,j+1) // replace
        );
    }
    int minDistance(string word1, string word2) {
        n = word1.size();
        m = word2.size();
        // 꼭 +1 해야한다. 기저 상황 때문
        dp = vector<vector<int>>(n+1, vector<int>(m+1, -1));
        return solve(word1, word2, 0, 0);
    }
};

int main(void){
    Solution sol = Solution();
    cout << sol.minDistance("intention", "execution");
    return 0;
}