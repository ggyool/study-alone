#include <iostream>
#include <algorithm>
#include <vector>
#include <cstring>
using namespace std;

// 복습 - 중복 체크하는걸 개선하려고 시도하였음.
// 처음에는 메모이제이션 사용하려고 했지만, 개수 구현하는게 편할듯 싶었음.
// 2차원으로 각각 배열 만들었다가, 느려서 3차원으로 만들어도 보았지만
// 연산이 많아서 그런가, 그냥 체크하는 것 보다 더 느리다.
int n;
int arr[2188][2188];
int cnt[3][2188][2188];
// -1,0,1 개수 
int ans[3];


void check(int y, int x, int s){
    if(s==1){
        ++ans[arr[y][x]+1];
        return;
    }
    
    int idx = arr[y][x] + 1;
    int targetCnt = cnt[idx][y+s-1][x+s-1] + cnt[idx][y-1][x-1] - cnt[idx][y+s-1][x-1] - cnt[idx][y-1][x+s-1];
    if(targetCnt == s*s){
        ++ans[idx];
        return;
    }
    int slice = s/3;
    for(int i=0; i<s; i+=slice){
        for(int j=0; j<s; j+=slice){
            check(y+i, x+j, slice);
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
    for(int k=0; k<3; ++k){
        for(int i=1; i<=n; ++i){
            for(int j=1; j<=n; ++j){
                cnt[k][i][j] = cnt[k][i-1][j] + cnt[k][i][j-1] - cnt[k][i-1][j-1];
                if(arr[i][j] == k-1){
                    ++cnt[k][i][j];
                }
            }
        }
    }
    check(1,1,n);
    cout << ans[0] << '\n';
    cout << ans[1] << '\n';
    cout << ans[2] << '\n';
    
    return 0;
}
