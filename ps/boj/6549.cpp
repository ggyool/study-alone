#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <cstring>
using namespace std;

typedef long long ll;
int n;
vector<ll> v;

ll solve(int left, int right){
    if(left==right) return v[left];
    int mid = left + (right-left)/2;
    
    ll ret = max(solve(left, mid), solve(mid+1, right));
    ll h = min(v[mid], v[mid+1]);
    ret = max(ret, 2*h);
    int i = mid-1;
    int j = mid+2;
    
    while(left<=i && j<=right){
        if(v[i]<v[j]) {
            h = min(h, v[j++]);
        }
        else{
            h = min(h, v[i--]);
        }
        ret = max(ret, h*(j-i-1));
    }
    while(left<=i){
        h = min(h, v[i--]);
        ret = max(ret, h*(j-i-1));
    }
    while(j<=right){
        h = min(h, v[j++]);
        ret = max(ret, h*(j-i-1));
    }
    return ret;
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    while(true){
        cin >> n;
        if(n==0) break;
        v.clear();
        for(int i=0; i<n; ++i){
            ll num;
            cin >> num;
            v.push_back(num);
        }
        cout << solve(0, n-1) << '\n';
    }
    return 0;
}

