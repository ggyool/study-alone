#include <iostream>
using namespace std;

int n;

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n;
    if(n==1) {
        cout << 1;
        return 0;
    }
    
    for(int i=2; i*i<=n; ++i){
        while(n%i==0){
            cout << i << '\n'; 
            n/=i;
        }
    }
    if(n>1) cout << n;
}