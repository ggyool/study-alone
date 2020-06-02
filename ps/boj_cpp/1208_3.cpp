#include <iostream>
#include <vector>
#include <algorithm>
#include <unordered_map>
using namespace std;

typedef long long ll;
int n,s;

// 아이디어 참고 투포인터! 

vector<int> va, vb, vsa, vsb;

void findSubset(int i, int sum, vector<int> &v, vector<int> &vs){
    if(i==v.size()) return;

    vs.push_back(sum+v[i]);
    findSubset(i+1, sum+v[i], v, vs);

    findSubset(i+1, sum, v, vs);
}

ll solve(){
    ll ret = 0;
    if(s==0) --ret;
    int alen = vsa.size();
    int blen = vsb.size();
    sort(vsa.begin(), vsa.end());
    sort(vsb.begin(), vsb.end());
    int i = 0;
    int j = blen - 1;
    // 하나라도 범위를 벗어나면 빠져나오기
    while(i<alen && j>=0){
        if(vsa[i] + vsb[j] > s) {  
            --j;
        }
        if(vsa[i] + vsb[j] < s) {  
            ++i;
        }
        // 같은 경우에 따로 처리를 해줘야한다.
        if(vsa[i] + vsb[j] == s) {
            int ta = vsa[i];
            int tb = vsb[j];
            ll ca = 0, cb = 0;
            while(i<alen && ta==vsa[i]){
                ++ca;
                ++i;
            }
            while(j>=0 && tb==vsb[j]){
                ++cb;
                --j;
            }
            ret += ca*cb;
        }
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
    findSubset(0, 0, va, vsa);
    findSubset(0, 0, vb, vsb);
    cout << solve();
    return 0;
}
