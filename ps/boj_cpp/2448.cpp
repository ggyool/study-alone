#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int n;
// n, 2n-1
char arr[3073][6144];

// 위 꼭지점 기준
void draw(int y, int x, int s){
    if(s==3){
        arr[y][x] = '*';
        arr[y+1][x-1] = '*';
        arr[y+1][x+1] = '*';
        for(int i=0; i<5; ++i){
            arr[y+2][x-2+i] = '*';
        }
        return;
    }
    
    draw(y,x,s/2);
    draw(y+s/2,x+s/2,s/2);
    draw(y+s/2,x-s/2,s/2);
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n;
    for(int i=0; i<n; ++i){
        for(int j=0; j<2*n-1; ++j){
            arr[i][j] = ' ';
        }
    }
    int x = (2*n-1)/2;
    draw(0,x,n);
    for(int i=0; i<n; ++i){
        cout << arr[i] << '\n'; 
    }
    return 0;
}
