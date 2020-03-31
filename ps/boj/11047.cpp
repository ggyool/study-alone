#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int n,k;
vector<int> v;

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n >> k;
    int num;
    for(int i=0; i<n; ++i){
        cin >> num;
        v.push_back(num);
    }
    int ans = 0;
    for(int i=0; i<n; ++i){
        ans += k/v[n-1-i];
        k = k%v[n-1-i];
    }
    cout << ans;
    return 0;
}
