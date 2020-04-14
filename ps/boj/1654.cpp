#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <cstring>
#include <climits>
using namespace std;


typedef long long ll;
int k, n;
vector<int> v;

bool isAble(int val){
    ll cnt = 0;
    for(int i=0; i<k; ++i){
        cnt += v[i] / val;
    }
    return cnt>=n;
}

ll solve(){
    ll left = 1;
    ll right = INT_MAX + 1L;
    ll mid;
    ll ret=0;
    while(left<=right){
        mid = left + (right-left)/2;
        if(isAble(mid)){
            left = mid+1;
            ret = max(ret, mid);
        }
        else{
            right = mid-1;
        }
    }
    return ret;
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> k >> n;
    int num;
    for(int i=0; i<k; ++i){
        cin >> num;
        v.push_back(num);
    }
    cout << solve();
    return 0;
}

