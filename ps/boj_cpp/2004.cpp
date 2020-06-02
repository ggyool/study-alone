#include <iostream>
#include <algorithm>
using namespace std;

typedef long long ll;
int n, m;

int counting(int facNum, int num){
    int ret = 0;
    // facNum 은 20억 이지만 마지막 i곱할 때 overflow
    for(ll i=num; i<=facNum; i*=num){
        ret += facNum / i;
    }
    return ret;
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n >> m;
    int totalTwo = counting(n, 2) - counting(m, 2) - counting(n-m, 2);
    int totalFive = counting(n, 5) - counting(m, 5) - counting(n-m, 5);
    cout << min(totalTwo, totalFive);
}