#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
using namespace std;

int r,c;
int arr[50][50];
int ans[50][50];

void swap(int y, int x){
    for(int i=0; i<3; ++i){
        for(int j=0; j<3; ++j){
            arr[y+i][x+j] = 1-arr[y+i][x+j]; 
        }
    }
}

bool check(){
    for(int i=0; i<r; ++i){
        for(int j=0; j<c; ++j){
            if(arr[i][j] != ans[i][j]) return false;
        }
    }
    return true;
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> r >> c;
    string s;
    for(int i=0; i<r; ++i){
        cin >> s;
        for(int j=0; j<c; ++j){
            arr[i][j] = s[j]-'0';
        }
    }
    for(int i=0; i<r; ++i){
        cin >> s;
        for(int j=0; j<c; ++j){
            ans[i][j] = s[j]-'0';
        }
    }
    int cnt = 0;
    for(int i=0; i<=r-3; ++i){
        for(int j=0; j<=c-3; ++j){
            if(arr[i][j] != ans[i][j]){
                swap(i,j);
                ++cnt;
            }
        }
    }
    if(check()) cout << cnt;
    else cout << -1;
    return 0;
}
