#include <iostream>
#include <vector>
#include <algorithm>
#include <cstring>
using namespace std;


int n;
vector<pair<int,int>> v;
uint dp[500][500];

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n;
    for(int i=0; i<n; ++i){
        int a,b;
        cin >> a >> b;
        v.push_back({a,b});
    }
    for(int i=0; i+1<n; ++i){
        dp[i][i+1] = v[i].first * v[i].second * v[i+1].second;
    }
    // i:간격, j:left, k:right
    for(int i=2; i<n; ++i){
        for(int j=0; j+i<n; ++j){
            dp[j][j+i] = 1<<31;
            for(int k=j; k<=j+i-1; ++k){
                dp[j][j+i] = min(dp[j][j+i], dp[j][k] + dp[k+1][j+i] + v[j].first*v[k].second*v[j+i].second);
            }
        }
    }
    cout << dp[0][n-1];
    return 0;
}
