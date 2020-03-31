#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int n,m,k;

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n >> m >> k;
    int make = min(n/2, m);
    int remain = n - 2*make + m-make;
    k -= remain;
    if(k>0){
        make -= (k / 3) + (k%3>0);
    }
    cout << make;

    return 0;
}
