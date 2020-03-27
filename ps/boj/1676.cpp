#include <iostream>
using namespace std;

int n;

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n;
    // 5의 개수가 더 적으므로, 5의 개수만 구하면 된다.
    int five = 0;
    for(int i=5; i<=n; i*=5){
        five += (n/i);
    }
    cout << five;
}