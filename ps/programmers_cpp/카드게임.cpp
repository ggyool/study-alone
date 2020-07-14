#include <string>
#include <vector>
#include <algorithm>
#include <cstring>
#include <iostream>
using namespace std;

const int INF = 987654321;
int dp[2001][2001];
vector<int> lv, rv;
int ln, rn;

int solve(int i, int j){
    if(j==rn || i==ln) {
        return 0;
    }
    //if() return -INF;
    int &ret = dp[i][j];
    if(ret!=-1) return ret;
    ret = -INF;
    ret = max(solve(i+1, j), solve(i+1, j+1));
    if(lv[i]>rv[j]){
        ret = max(ret, solve(i, j+1) + rv[j]);
    }
    return ret;
}



int solution(vector<int> left, vector<int> right) {
    lv = left;
    rv = right;
    ln = left.size();
    rn = right.size();
    for(int i=0; i<=ln; ++i){
        for(int j=0; j<=rn; ++j){
            dp[i][j] = -1;
        }
    }
    return solve(0,0);
}

int main(void){
    vector<int> v1 ={3,3,1};
    vector<int> v2 ={7,7,1};
    // vector<int> v1 ={3,2,5};
    // vector<int> v2 ={2,4,1};
    cout << solution(v1,v2) << '\n';
    for(int i=0; i<ln; ++i){
        for(int j=0; j<rn; ++j){
            cout << i << ' ' << j << ' ' << solve(i,j) << '\n';
        }
    }
}


/*



int ln = left.size();
    int rn = right.size();
    for(int i=0; i<ln; ++i){
        for(int j=0; j<rn; ++j){
            
        }
    }
    int ret = 0;
    for(int i=0; i<ln; ++i){
        if(right[0]<left[i]) dp[i][0] = right[0];
    }
    for(int i=0; i<ln; ++i){
        for(int j=0; j<rn; ++j){
            if(j-1>=0) dp[i][j] = dp[i][j-1];
            if(i-1>=0){
                dp[i][j] = max(dp[i][j], dp[i-1][j]);
            }
            if(i-1>=0 && j-1>=0)
                dp[i][j] = max(dp[i][j], dp[i-1][j-1]);
            if(j-1>=0 && i>=j && left[i]>right[j]){
                dp[i][j] = max(dp[i][j], dp[i][j-1] + right[j]);
                
            }    
            ret = max(ret, dp[i][j]);
        }
    }    
*/