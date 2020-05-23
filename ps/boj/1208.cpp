#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

typedef long long ll;
int n,s;

vector<int> va, vb, vsa, vsb;

ll lowerBound(int left, int right, int val, vector<int> &v){
    int mid;
    while(left<right){
        mid = left + (right-left)/2;
        if(v[mid]>=val) right = mid;
        else left = mid+1;
    }
    return right;
}

ll upperBound(int left, int right, int val, vector<int> &v){
    int mid;
    while(left<right){
        mid = left + (right-left)/2;
        if(v[mid]<=val) left = mid+1;
        else right = mid;
    }
    return right;
}

void findSubset(int i, int sum, vector<int>& v, vector<int>& vs){
    if(i==v.size()) return;

    vs.push_back(sum+v[i]);
    findSubset(i+1, sum+v[i], v, vs);

    findSubset(i+1, sum, v, vs);
}

ll solve(){
    ll ret = 0;
    if(s==0) --ret;
    sort(vsa.begin(), vsa.end());
    sort(vsb.begin(), vsb.end());
    int alen = vsa.size();
    int blen = vsb.size();
    for(int i=0; i<alen; ++i){
        // ret += upperBound(0, blen, s-vsa[i], vsb) - lowerBound(0, blen,  s-vsa[i], vsb);
        auto p = equal_range(vsb.begin(), vsb.end(), s-vsa[i]);
        ret += (p.second-p.first);
    }
    return ret;
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n >> s;
    for(int i=0; i<n; ++i){
        int num;
        cin >> num;
        if(i<n/2){
            va.push_back(num);
        }
        else{
            vb.push_back(num);
        }
    }
    vsa.push_back(0);
    vsb.push_back(0);
    // 0~n/2, n/2+1, n-1
    findSubset(0, 0, va, vsa);
    findSubset(0, 0, vb, vsb);
    cout << solve();
    return 0;
}
