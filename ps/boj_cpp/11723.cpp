#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int n, m;

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> m;
    string s;
    for(int i=0; i<m; ++i){
        cin >> s;
        if(s=="all"){
            n = (1<<20)-1;
        }
        else if(s=="empty"){
            n = 0;
        }
        else{
            int a;
            cin >> a;
            if(s=="add") n |= 1<<(a-1);
            else if(s=="remove") n &= ~(1<<(a-1));
            else if(s=="check") cout << ((n & (1<<(a-1)))>0) << '\n';
            else if(s=="toggle") n ^= 1<<(a-1);
        }
    }
    return 0;
}
