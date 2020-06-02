#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

// 풀다가 1인 경우는 곱하면 안 되는 것을 깨달았다.
// +=2 가 구현이 더 편하겠다는 생각을 했다.
int n;
vector<int> pov, nev;
int zeroCnt = 0;

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n;
    int num;
    for(int i=0; i<n; ++i){
        cin >> num;
        if(num == 0) ++zeroCnt;
        else if(num<0) nev.push_back(num);
        else pov.push_back(num);
    }
    sort(nev.begin(), nev.end());
    sort(pov.begin(), pov.end());
    int ans = 0;
    int len = pov.size();
    int tmp = 0;
    for(int i=0; i<len; ++i){
        if(i%2) {
            if(pov[len-i-1]==1) tmp += pov[len-i-1];
            else tmp *= pov[len-i-1];
            ans += tmp;
            tmp = 0;
        }
        else{
            tmp = pov[len-i-1];
        }
    }
    ans += tmp;
    
    tmp = 0;
    len = nev.size();
    for(int i=0; i<len; ++i){
        if(i%2){
            tmp *= nev[i];
            ans += tmp;
            tmp = 0;
        }
        else{
            tmp = nev[i];
        }
    }
    if(zeroCnt==0) ans += tmp;
    cout << ans;

    return 0;
}
