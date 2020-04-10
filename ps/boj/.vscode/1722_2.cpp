#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

// 한참 뒤에 다시 풀어도 똑같은 발상인게 신기하다.
// 누적하며 빼나가는 방법으로 1722를 업그레이드 시킨 코드
typedef long long ll;
ll fact[21];

void findPermutation(int n, ll m, vector<int>& v){
    vector<bool> visited(n+1, false);
    // 자리수
    for(int d=0; d<n; ++d){
        // 넣을 숫자
        for(int i=1; i<=n; ++i){
            if(visited[i]) continue;
            if(m<=fact[n-d-1]) {
                v[d] = i;
                visited[i] = true;
                break;
            }
            else{
                m -= fact[n-d-1];
            }
        }
    }
}


ll findN(int n, vector<int>& v){
    ll ret = 0;
    vector<bool> visited(n+1, false);
    // 뒤에 작은 숫자가 몇 개 있는지
    for(int i=0; i<n-1; ++i){
        for(int j=1; j<v[i]; ++j){
            if(visited[j]) continue;
            ret += fact[n-i-1];
        }
        visited[v[i]] = true;
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
    