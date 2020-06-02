#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <cstring>
using namespace std;

int arr[9][9];
bool row[9][10];
bool col[9][10];
bool sq[9][10]; 

int toIndex(int y, int x){
    return y/3*3 + x/3;
}

bool find(int y, int x){
    if(y==8 && x==9) {
        for(int i=0; i<9; ++i){
            for(int j=0; j<9; ++j){
                cout << arr[i][j] << ' ';
            }
            cout << '\n';
        }
        return true;
    }
    if(x==9) return find(y+1, 0);
    if(arr[y][x] != 0) return find(y, x+1);
    for(int i=1; i<=9; ++i){
        if(!row[y][i] && !col[x][i] && !sq[toIndex(y,x)][i]){
            row[y][i] = true;
            col[x][i] = true;
            sq[toIndex(y,x)][i] = true;
            arr[y][x] = i;
            if(find(y, x+1)) return true;
            row[y][i] = false;
            col[x][i] = false;
            sq[toIndex(y,x)][i] = false;
            arr[y][x] = 0;
        }
    }
    return false;
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    for(int i=0; i<9; ++i){
        for(int j=0; j<9; ++j){
            cin >> arr[i][j];
            row[i][arr[i][j]] = true;
            col[j][arr[i][j]] = true;
            sq[toIndex(i,j)][arr[i][j]] = true;
        }
    }
    find(0, 0);
    
    return 0;
}

