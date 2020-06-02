#include <iostream>
using namespace std;

int n = -1;
bool notPrime[(int)1e6+1];

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    notPrime[1] = true;
    // nlognlogn
    // 남아있으면 소수, 배수 다 not 소수
    for(int i=2; i*i<=(int)1e6; ++i){
        if(notPrime[i] == false){
            // ovelflow 때문에 보통 2*i 라고 씀
            for(int j=2*i; j<=(int)1e6; j+=i){
                notPrime[j] = true;
            }
        }
    }
    
    while(n!=0){
        cin >> n;
        for(int i=3; i<=n/2; i+=2){
            if(notPrime[i] == false && notPrime[n-i] == false){
                cout << n << " = "  << i << " + " << n-i << '\n';
                break;
            }
        }
    }
    return 0;
}