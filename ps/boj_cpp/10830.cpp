#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <cstring>
using namespace std;

typedef long long ll;
typedef vector<vector<int>> vv;
const int MOD = 1000;
ll n,b;
vv v;

vv product(vv &va, vv &vb){
    vv ret(n, vector<int>(n));
    for(int i=0; i<n; ++i){
        for(int j=0; j<n; ++j){
            for(int l=0; l<n; ++l){
                ret[i][l] += va[i][j] * vb[j][l];
                ret[i][l] %= MOD;
            }
        }
    }
    return ret;
}

vv calc(ll exp){
    if(exp==1) return v;
    vv tv = calc(exp/2);
    vv ret = product(tv, tv);
    if(exp&1) ret = product(ret, v);
    return ret;
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n >> b;
    v = vv(n, vector<int>(n));
    for(int i=0; i<n; ++i){
        for(int j=0; j<n; ++j){
            cin >> v[i][j];
            v[i][j] %= MOD;
        }
    }
    vv res = calc(b);
    for(int i=0; i<n; ++i){
        for(int j=0; j<n; ++j){
            cout << res[i][j] << ' ';
        }
        cout << '\n';
    }
    return 0;
}
