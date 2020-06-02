#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
using namespace std;

int n;
char arr[65][65];

bool check(int y, int x, int s){
    for(int i=0; i<s; ++i){
        for(int j=0; j<s; ++j){
            if(arr[y][x] != arr[y+i][x+j]) return false;
        }
    }
    return true;
}

void solve(int y, int x, int s){
    if(s==1) {
        cout << arr[y][x];
        return;
    }
    if(check(y,x,s)){
        cout << arr[y][x];
    }
    else{
        cout << '(';
        solve(y,x,s/2);
        solve(y,x+s/2,s/2);
        solve(y+s/2,x,s/2);
        solve(y+s/2,x+s/2,s/2);
        cout << ')';
    }
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n;
    for(int i=0; i<n; ++i){
        cin >> arr[i];
    }
    solve(0,0,n);
    return 0;
}
