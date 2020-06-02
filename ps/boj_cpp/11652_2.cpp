#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

// sort 사용
typedef long long ll;
vector<ll> v;
int n;

int main(void){ 
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    ll num;
    cin >> n;
    for(int i=0; i<n; ++i){
        cin >> num;
        v.push_back(num);
    }
    sort(v.begin(), v.end());
    int cnt = 1;
    ll ans = v[0];
    int maxCnt = 1;
    for(int i=1; i<n; ++i){
        if(v[i-1] == v[i]){
            ++cnt;
        }else{
            cnt = 1;
        }
        if(cnt > maxCnt){
            maxCnt = cnt;
            ans = v[i];
        }
    }
    cout << ans;
    return 0;
}