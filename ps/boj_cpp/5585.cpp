#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int n;

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n;
    n = 1000-n;
    int ans = 0;
    vector<int> v = {500, 100, 50, 10, 5, 1};
    for(int i=0; i<6; ++i){
        ans += n / v[i];
        n = n % v[i];
    }
    cout << ans;
    return 0;
}
