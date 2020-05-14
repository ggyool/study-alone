#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;


int n;
int arr[21][21];

int check(int x, int y){
    for(int i=1; i<=n; ++i){
        if(i==x || i==y) continue;
        if(arr[x][y] == arr[x][i]+arr[i][y]) return 0;
        if(arr[x][y] > arr[x][i]+arr[i][y]) return -1;
    }
    return arr[x][y];
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);   
    cin >> n;
    for(int i=1; i<=n; ++i){
        for(int j=1; j<=n; ++j){
            cin >> arr[i][j];
        }
    }
    int ans = 0;
    for(int i=1; i<=n; ++i){
        for(int j=i+1; j<=n; ++j){
            int res = check(i,j);
            if(res==-1) {
                cout << -1;
                return 0;
            }
            ans += res;
        }
    }
    cout << ans;
    return 0;
}
