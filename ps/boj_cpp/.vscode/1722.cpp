#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

typedef long long ll;
ll fact[21];

void findPermutation(int n, ll m, vector<int>& v){
    m -= 1;
    vector<bool> visited(n+1, false);
    for(int remain=n; remain>=1; --remain){
        for(int i=1; i<=remain; ++i){
            if(m<i*fact[remain-1]){
                m -= (i-1)*fact[remain-1];
                // i번째로 작은 수를 찾아야 한다.
                int cnt = 0;
                for(int j=1; j<=n; ++j){
                    if(visited[j]==false) ++cnt;
                    if(cnt==i){
                        visited[j] = true;
                        v[n-remain] = j;
                        i=10000;
                        break;
                    }
                }
            }
        }
    }
}


ll findN(int n, vector<int>& v){
    ll ret = 0;
    // 자신보다 뒤에 작은 숫자가 몇 개 있는지
    for(int i=0; i<n-1; ++i){
        ll cnt = 0;
        for(int j=i+1; j<n; ++j){
            if(v[j]<v[i]) ++cnt;
        }
        ret += cnt*fact[n-i-1];
    }
    return ret+1;
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    fact[0] = 1;
    for(int i=1; i<=20; ++i){
        fact[i] = fact[i-1] * i;
    }
    int n;
    ll m;
    int cmd;
    cin >> n;
    cin >> cmd;
    if(cmd==1){
        cin >> m;
        vector<int> v(n);
        findPermutation(n, m, v);
        for(int i=0; i<n; ++i){
            cout << v[i] << ' ';
        }
    }
    else{
        vector<int> v(n);
        for(int i=0; i<n; ++i){
            cin >> v[i];
        }
        cout << findN(n, v);
    }
    return 0;
}
