#include <iostream>
#include <vector>
#include <algorithm>
#include <cstring>
using namespace std;

const int N = 4000000;
bool isPrime[N+1];
int n;
vector<int> pv;

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n;
    for(int i=0; i<=n; ++i) isPrime[i] = true;
    isPrime[0] = false;
    isPrime[1] = false;
    for(int i=2; i*i<=n; ++i){
        if(isPrime[i]){
            for(int j=2*i; j<=n; j+=i){
                isPrime[j] = false;
            }
        }   
    }
    for(int i=0; i<=n; ++i){
        if(isPrime[i]) 
            pv.push_back(i);
    }
    int ans = 0;
    int sum = 0;
    int len = pv.size();
    int i = 0, j = 0;
    while(j<len || sum>n){
        if(sum < n){
            sum += pv[j++];
        }
        else{   
            sum -= pv[i++];
        }
        if(sum==n) ++ans; 
    }
    cout << ans;
    return 0;
}
