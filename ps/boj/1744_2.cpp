#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;


int n;
vector<int> pov, nev;
int zeroCnt = 0;
int oneCnt = 0;

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n;
    int num;
    for(int i=0; i<n; ++i){
        cin >> num;
        if(num == 0) ++zeroCnt;
        else if(num == 1) ++oneCnt;
        else if(num<0) nev.push_back(num);
        else pov.push_back(num);
    }
    sort(nev.begin(), nev.end());
    sort(pov.begin(), pov.end());
    int ans = 0;
    int len = pov.size();
    for(int i=len-2; i>=0; i-=2){
        ans += (pov[i] * pov[i+1]);
    }
    if(len%2) ans += pov[0];

    len = nev.size();
    for(int i=1; i<len; i+=2){
        ans += (nev[i] * nev[i-1]);
    }
    if(len%2 && zeroCnt==0) ans += nev[len-1];
    ans += oneCnt;
    cout << ans;

    return 0;
}
