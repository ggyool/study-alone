#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
using namespace std;
/*
반대의 경우
8
((110(0101))(0010)1(0001)
------------------------------
11110000
11110000
00011100
00011100
11110000
11110000
11110011
11110011
*/


int n, slen;
char arr[65][65];
string s;

void fill(int y, int x, int side, char c){
    for(int i=0; i<side; ++i){
        for(int j=0; j<side; ++j){
            arr[y+i][x+j] = c;
        }
    }
}

int solve(int y, int x, int idx, int side){
    if(idx>=slen) return -1;
    char c = s[idx];
    if(c=='('){
        idx = solve(y, x, idx+1, side/2);
        idx = solve(y, x+side/2, idx, side/2);
        idx = solve(y+side/2, x, idx, side/2);
        idx = solve(y+side/2, x+side/2, idx, side/2);
    }
    else{
        fill(y, x, side, c);
    }
    return idx+1;
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n;
    cin >> s;
    slen = s.size();
    solve(0, 0, 0, n);
    for(int i=0; i<n; ++i){
        for(int j=0; j<n; ++j){
            cout << arr[i][j];
        }
        cout << '\n';
    }
    return 0;
}
