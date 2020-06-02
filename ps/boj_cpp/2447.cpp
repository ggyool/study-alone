#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int n;
char arr[2188][2188];

void draw(int y, int x, int s){
    if(s==1) {
        arr[y][x] = '*';
        return;
    }
    int slice = s/3;
    for(int i=0; i<s; i+=slice){
        for(int j=0; j<s; j+=slice){
            if(i==slice && j==slice) continue;
            draw(y+i, x+j, slice);
        }
    }
}


int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n;
    for(int i=0; i<n; ++i){
        for(int j=0; j<n; ++j){
            arr[i][j] = ' ';
        }
    }
    draw(0,0,n);
    for(int i=0; i<n; ++i){
        cout << arr[i] << '\n';
    }
    return 0;
}
