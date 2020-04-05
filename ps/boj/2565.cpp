#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int n;
vector<pair<int,int>> v;
int dp[100];

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
    sort(v.begin(), v.end());
    int lis = 1;
    dp[0] = 1;
    for(int i=1; i<n; ++i){
        dp[i] = 1;
        for(int j=0; j<i; ++j){
            if(v[j].first<v[i].first && v[j].second<v[i].second){
                dp[i] = max(dp[i], dp[j] + 1);
            }
        }
        lis = max(lis, dp[i]);
    }
    cout << n - lis;
    return 0;
}
