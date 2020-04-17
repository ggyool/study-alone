#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <cstring>
using namespace std;

int n,k,x,y;
int arr[128][128];
int cnt = 1;

int findDistrict(int r, int c, int s){
    for(int i=0; i<s; ++i){
        for(int j=0; j<s; ++j){
            if(arr[r+i][c+j] != 0){
                if(i<s/2){
                    if(j<s/2) return 1;
                    else return 2;
                }
                else{
                    if(j<s/2) return 3;
                    else return 4;
                }
            }
        }
    }
    return -1;
}

void fillZero(int r, int c, int s){
    for(int i=0; i<s; ++i){
        for(int j=0; j<s; ++j){
            if(arr[r+i][c+j]==0) 
                arr[r+i][c+j] = cnt;
        }
    }
    ++cnt;
}


void fillCenter(int r, int c, int s, int dist){
    r = r + s/2 - 1;
    c = c + s/2 - 1;
    for(int i=0;i<4; ++i){
        if(dist-1==i) continue;
        arr[r+i/2][c+i%2] = cnt;
    }
    ++cnt;
}

// 채우는 아이디어가 잘 안떠올랐는데
// 4분면을 나눠서 있는 배수구가 있는 쪽 나머지 사분면으로 블럭을 놓고 시작하자.
// 처음에는 -1의 위치 나머지는 0이 아닌 숫자
void solve(int r, int c, int s){
    if(s==2){
        //zeroFill
        fillZero(r,c,s);
        return;
    }
    int dist = findDistrict(r,c,s);
    fillCenter(r,c,s,dist);

    int slice = s/2;
    solve(r,c,slice);
    solve(r,c+slice,slice);
    solve(r+slice,c,slice);
    solve(r+slice,c+slice,slice);
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> k >> x >> y;
    n = 1<<k;
    --x;
    y = n - y;
    arr[y][x] = -1;
    solve(0,0,n);
    for(int i=0; i<n; ++i){
        for(int j=0; j<n; ++j){
            cout << arr[i][j] << ' ';
        }
        cout << '\n';
    }
    return 0;
}

