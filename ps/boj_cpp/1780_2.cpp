#include <iostream>
#include <algorithm>
#include <vector>
#include <cstring>
using namespace std;


// 1780.cpp 이 느린이유가 부가 연산이 많아서라고 생각하여
// 개선히려 노력했으나 비슷하게 느림
int n;
int arr[2188][2188];
int dp[2188][2188][8];
// -1,0,1 개수 
int ans[3];
int log3[2188];


int check(int y, int x, int s){
    if(s==1) return arr[y][x];
    int &ret = dp[y][x][log3[s]];
    if(ret!=0x3f3f3f3f) return ret;
    ret = arr[y][x];
    int slice = s/3;
    for(int i=0; i<s; i+=slice){
        for(int j=0; j<s; j+=slice){
            int res = check(y+i, x+j, slice);
            if(ret!=-2 && res!=arr[y][x]){
                ret = -2;
            }
        }
    }
    return ret;
}

void solve(int y, int x, int s){
    int slice = s/3;
    int res = check(y,x,s);
    if(res!=-2) {
        ++ans[res+1];
    }
    else{
        for(int i=0; i<s; i+=slice){
            for(int j=0; j<s; j+=slice){
                solve(y+i, x+j, slice);
            }
        }
    }
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
    memset(dp, 0x3f, sizeof(dp));
    int val = 3;
    for(int i=1; i<=7;++i){
        log3[val] = i;
        val *= 3;
    }
    if(n==1){
        ++ans[arr[1][1]+1];
    }
    else solve(1,1,n);
    cout << ans[0] << '\n';
    cout << ans[1] << '\n';
    cout << ans[2] << '\n';
    
    return 0;
}
