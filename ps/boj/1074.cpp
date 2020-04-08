#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int n, r, c;

int solve(int y0, int x0, int s, int y, int x){
    if(s==1) return 1;
    if(y < y0+s/2){
        if(x < x0+s/2){
            return solve(y0,x0,s/2,y,x);
        }
        else{
            return s/2*s/2 + solve(y0,x0+s/2,s/2,y,x);
        }
    }
    else{
        if(x < x0+s/2){
            return 2*s/2*s/2 + solve(y0+s/2,x0,s/2,y,x);
        }
        else{
            return 3*s/2*s/2 + solve(y0+s/2,x0+s/2,s/2,y,x);
        }
    }
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n >> r >> c;
    cout << solve(0, 0, 1<<n, r, c) - 1;
    return 0;
}
