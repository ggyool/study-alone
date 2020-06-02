#include <iostream>
using namespace std;

int n;
bool notPrime[1001];

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n;
    notPrime[1] = true;
    for(int i=1; i<=1000; ++i){
        for(int j=2; j*j<=i; ++j){
            if(i%j==0) {
                notPrime[i] = true;
                break;
            }
        }
    }
    int idx, ans = 0;
    for(int i=0; i<n; ++i){    
        cin >> idx;
        ans += !notPrime[idx];
    }
    cout << ans;
    return 0;
}