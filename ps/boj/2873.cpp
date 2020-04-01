#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
using namespace std;

// 다시 풀어도 어렵다.
// 똑같은 접근과 똑같은 실수.

int r,c;
int arr[1000][1000];
int dy[4];
int dx[4];
int minv = 987654321, miny,minx;

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> r >> c;
    for(int i=0; i<r; ++i){
        for(int j=0; j<c; ++j){
            cin >> arr[i][j];
        }
    }
    if(r%2==1){
        for(int i=0; i<r; ++i){
            char ch;
            if(i%2==0) ch = 'R';
            else ch='L';
            for(int j=0; j<c-1; ++j) cout << ch;
            if(i!=r-1) cout << 'D';
        }
    }
    else if(c%2==1){
        for(int j=0; j<c; ++j){
            char ch;
            if(j%2==0) ch='D';
            else ch='U';
            for(int i=0; i<r-1; ++i) cout << ch;
            if(j!=c-1) cout << 'R';
        }
    }
    else{
        for(int i=0; i<r; ++i){
            for(int j=0; j<c; ++j){
                if((i+j)%2==1){
                    if(arr[i][j] < minv){
                        minv = arr[i][j];
                        miny = i;
                        minx = j;
                    }
                }
            }
        }
        int y=0;
        bool pass = false;
        while(y<r){
            if(miny/2 == y/2){
                pass = true;
                int x = 0;
                while(x<c){
                    if(minx!=x){
                        if(y%2==0) cout << 'D', ++y;
                        else cout << 'U', --y;
                    }
                    if(x==c-1) {
                        if(y!=r-1) cout << 'D';
                        ++y;
                    }
                    else cout << 'R';
                    ++x;
                }
            }
            else{
                if(!pass) {
                    for(int j=0; j<c-1; ++j) cout << 'R';
                    cout << 'D';
                    for(int j=0; j<c-1; ++j) cout << 'L';
                    cout << 'D';
                }
                else{
                    for(int j=0; j<c-1; ++j) cout << 'L';
                    cout << 'D';
                    for(int j=0; j<c-1; ++j) cout << 'R';
                    if(y!=r-2) cout << 'D';
                }
                y+=2;
            }
        }
    }
    return 0;
}

