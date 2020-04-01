#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int tc, n;
vector<pair<int,int>> v;

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> tc;
    while(tc--){
        cin >> n;
        for(int i=0; i<n; ++i){
            int a,b;
            cin >> a >> b;
            v.push_back({a,b});
        }
        sort(v.begin(), v.end());
        int ans = 1;
        int minv = v[0].second;
        for(int i=1; i<n; ++i){
            if(v[i].second<minv){
                minv = v[i].second;
                ++ans;
            }
        }
        cout << ans << '\n';
        v.clear();
    }
    return 0;
}
