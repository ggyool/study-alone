#include <iostream>
using namespace std;

int m, n;
bool notPrime[(int)1e6+1];

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> m >> n;
    notPrime[1] = true;
    // nlognlogn
    // 남아있으면 소수, 배수 다 not 소수
    for(int i=2; i*i<=n; ++i){
        if(notPrime[i] == false){
            // ovelflow 때문에 보통 2*i 라고 씀
            for(int j=i*i; j<=n; j+=i){
                notPrime[j] = true;
            }
        }
    }
    for(int i=m; i<=n; ++i){
        if(notPrime[i] == false) cout << i << '\n';
    }
    return 0;
}