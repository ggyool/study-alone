#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int n;
    cin >> n;
    vector<int> v;
    for(int i=0; i<n; ++i){
        int num;
        cin >> num;
        v.push_back(num);
    }
    sort(v.begin(), v.end());
    int len = v.size();
    int ans = 0;
    for(int i=1; i<len; ++i){
        ans += v[i] - v[i-1];
    }
    cout << ans;
    return 0;
}
