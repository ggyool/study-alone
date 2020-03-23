#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

const int SMALL = -987654321;
int tc, n, k, p;
vector<vector<int>> v;
vector<vector<int>> psum;
vector<vector<int>> dp;

int pick(int idx, int remain){
    if(remain==0){
        return 0;
    }
    if(idx>n){
        return SMALL;
    }
    int &ret = dp[idx][remain];
    if(ret!=-1) return ret;
    ret = SMALL;
    // pick count
    int len = min(k, remain);
    for(int i=0; i<=len; ++i){
        ret = max(ret, pick(idx+1, remain-i) + psum[idx][i]);
    }
    return ret;
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> tc;
    for(int t=1; t<=tc; ++t){
        cin >>n >> k >> p;
         v = vector<vector<int>>(n+1, vector<int>(k+1, 0));
         dp = vector<vector<int>>(n+1, vector<int>(n*k+1, -1));
         psum = vector<vector<int>>(n+1, vector<int>(k+1, 0));
        for(int i=1; i<=n; ++i){
            for(int j=1; j<=k; ++j){
                cin >> v[i][j];
            }
        }
        for(int i=1; i<=n; ++i){
            for(int j=1; j<=k; ++j){
                psum[i][j] = psum[i][j-1] + v[i][j];
            }
        }

        int ans = pick(1,p);
        cout << "Case #" + to_string(t) + ": " + to_string(ans) << '\n';
    }
    return 0;
}

