#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <cstring>
using namespace std;

typedef long long ll;

bool sn[1000001];

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    memset(sn, true, sizeof(sn));
    ll n, m;
    cin >> n >> m;
    int cnt = 0;
    for(ll i=2; i*i<=m; ++i){
        ll sq = i*i;
        ll start = n/sq*sq;
        if(start<n) start += sq;
        for(ll j=start; j<=m; j+=sq){
            sn[j-n] = false;
        }
    }
    for(ll i=n; i<=m; ++i){
        if(sn[i-n]) ++cnt;
    }
    cout << cnt;
    return 0;
}

