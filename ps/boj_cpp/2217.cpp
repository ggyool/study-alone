#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    vector<int> v;
    int n, w;
    cin >> n;
    for(int i=0; i<n; ++i){
        cin >> w;
        v.push_back(w);
    }
    sort(v.begin(), v.end());
    int ans = 0 ;
    for(int i=0; i<n; ++i){
        ans = max(ans, v[i] * (n-i));
    }
    cout << ans;
    return 0;
}
