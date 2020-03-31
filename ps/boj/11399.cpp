#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int n;
vector<int> v;

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n;
    int num;
    for(int i=0; i<n ;++i){
        cin >> num;
        v.push_back(num);
    }
    sort(v.begin(), v.end());
    int ans = 0;
    int sum = 0;
    for(int i=0; i<n; ++i){
        sum += v[i];
        ans += sum;
    }
    cout << ans;
    return 0;
}
