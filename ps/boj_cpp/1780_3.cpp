#include <iostream>
#include <algorithm>
#include <vector>
#include <cstring>
using namespace std;

// 단순한 코드 속도 궁금해서 만듬
int n;
int arr[2188][2188];
// -1,0,1 개수 
int ans[3];

bool isSame(int y, int x, int s){
    if(s==1) return true;
    int val = arr[y][x];
    for(int i=0; i<s; ++i){
        for(int j=0; j<s; ++j){
            if(val!=arr[y+i][x+j])
                return false;
        }
    }
    return true;
}

void solve(int y, int x, int s){
    if(isSame(y,x,s)){
        ++ans[arr[y][x]+1];
        return;
    }
    int slice = s/3;
    for(int i=0; i<s; i+=slice){
        for(int j=0; j<s; j+=slice){
            solve(y+i, x+j, slice);
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
    
    solve(1,1,n);
    cout << ans[0] << '\n';
    cout << ans[1] << '\n';
    cout << ans[2] << '\n';
    
    return 0;
}
