#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int n,m;

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n >>m;
    int mina=1001, minb=1001; 
    for(int i=0; i<m; ++i){
        int a,b;
        cin >> a >> b;
        mina = min(mina, a);
        minb = min(minb, b);
    }
    int ans = 0;
    if(mina<6*minb){
        ans += mina*(n/6);
        // 4개필요하지만 6개 사는게 더 쌀 수가있다.
        ans += min(mina, minb*(n%6));
    }
    else{
        ans += minb*n;
    }
    cout << ans;
    return 0;
}
