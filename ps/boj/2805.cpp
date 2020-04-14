#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <cstring>
using namespace std;

typedef long long ll;
int n, m;
vector<int> v;

bool isAble(int val){
    // integer overflow
    ll sum = 0;
    for(int i=0; i<n; ++i){
        sum += max(0, v[i]-val);
    }
    return sum >= m;
}

ll solve(){
    ll left = 0;
    ll right = (ll)1e9;
    ll mid, ret = 0;
    while(left<=right){
        mid = left + (right-left)/2;
        if(isAble(mid)){
            left = mid + 1;
            ret = max(ret, mid);
        }
        else{
            right = mid - 1;
        }
    }
    return ret;
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n >> m;
    for(int i=0; i<n; ++i){
        int num;
        cin >> num;
        v.push_back(num);
    }
    cout << solve();
    return 0;
}

