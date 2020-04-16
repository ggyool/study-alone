#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <cstring>
using namespace std;

int n,k,x,y;

void solve(int y, int x, int s){
    int slice = s/2;
    solve(y,x,slice);
    solve(y,x+slice,slice);
    solve(y+slice,x,slice);
    solve(y+slice,x+slice,slice);

}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> k >> x >> y;
    n = 1<<k;
    --x;
    y = n - y;
    solve(0,0,n);
    return 0;
}

