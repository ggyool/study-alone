#include <iostream>
#include <vector>
#include <algorithm>
#include <unordered_map>
using namespace std;

typedef long long ll;
int n,s;

// 처음과 같은 아이디어 맵사용 - 오히려 더 걸린다.

vector<int> va, vb;
unordered_map<int, ll> mpa, mpb;


void findSubset(int i, int sum, vector<int>& v, unordered_map<int, ll> & mp){
    if(i==v.size()) return;

    ++mp[sum+v[i]];
    findSubset(i+1, sum+v[i], v, mp);

    findSubset(i+1, sum, v, mp);
}

ll solve(){
    ll ret = 0;
    if(s==0) --ret;
    for(auto it=mpa.begin(); it!=mpa.end(); ++it){
        int val = it->first;
        int cnt = it->second;
        ret += mpb[s-val] * cnt;
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
    ++mpa[0];
    ++mpb[0];
    findSubset(0, 0, va, mpa);
    findSubset(0, 0, vb, mpb);
    cout << solve();
    return 0;
}
