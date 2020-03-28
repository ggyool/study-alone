#include <iostream>
#include <map>
using namespace std;

// map 사용
typedef long long ll;
map<ll, int> mp;
int n;

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    ll num;
    cin >> n;
    for(int i=0; i<n; ++i){
        cin >> num;
        mp[num]++;
    }
    int maxCnt = 0;
    ll ans;
    for(map<ll,int>::iterator it=mp.begin(); it!=mp.end(); ++it){
        ll val = it->first;
        int cnt = it->second;
        if(cnt > maxCnt){
            maxCnt = cnt;
            ans = val;
        }
    }
    cout << ans;
    return 0;
}