#include <iostream>
#include <string>
#include <cstring>
#include <algorithm>
#include <vector>
using namespace std;

// 처음 접근 보고 푼 풀이 _2에서 topDown 스럽게 다시 만듬
class Solution {
public:
    const int INF = (int)1e9;
    vector<vector<int>> dp;
    int n,m ;
    int threeMin(int x, int y, int z){
        return min(min(x, y), z); 
    } 
    int solve(string &sa, string &sb, int i, int j){
        if(i==0) return j; // 모두 insert
        if(j==0) return  i; // 모두 delete
        if(dp[i][j]!=-1) return dp[i][j];
        if(sa[i-1] == sb[j-1]){
            return dp[i][j] = solve(sa, sb, i-1, j-1);
        }
        return dp[i][j] = 1 + threeMin(solve(sa,sb,i-1,j), // delete
                 solve(sa,sb,i,j-1), // insert
                 solve(sa,sb,i-1,j-1) // replace
        );
    }
    int minDistance(string word1, string word2) {
        n = word1.size();
        m = word2.size();
        dp = vector<vector<int>>(n+1, vector<int>(m+1, -1));
        return solve(word1, word2, n, m);
    }
};

int main(void){
    Solution sol = Solution();
    cout << sol.minDistance("intention", "execution");
    return 0;
}