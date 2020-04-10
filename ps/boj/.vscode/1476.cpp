#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int e,s,m;

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> e >> s >> m;
    int cnt = 1;
    while(true){
        if(e==1 && s==1 && m==1) break;
        e--; s--; m--;
        if(e==0) e=15;
        if(s==0) s=28;
        if(m==0) m=19;
        ++cnt;
    }
    cout << cnt;
    return 0;
}
