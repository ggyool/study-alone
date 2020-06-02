#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

// 세로 3칸이상 가로 7칸이상
int n,m;

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n >> m;
    if(n<2) {
        cout << 1;
        return 0;
    }   
    else if(n==2){
        cout << min(4, 1 + (m-1)/2);
        return 0;
    }
    if(m>=7){
        cout << 5 + m-7;
    }
    else cout << min(4, 1 + (m-1));
    return 0;
}
