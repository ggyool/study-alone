#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int n,m;
bool isBreak[10]; 

bool isAble(int num){
    // 0일때 처리 안해서 몇번 소모
    if(num==0 && isBreak[0]) return false;
    while(num){
        int r = num%10;
        if(isBreak[r]) return false;
        num /= 10;
    }
    return true;
}

int digitCount(int num){
    // 0일때 처리 안해서 몇번 소모
    if(num==0) return 1;
    int ret = 0;
    while(num){
        ++ret;
        num /= 10;
    }
    return ret;
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n >> m;
    int num;
    for(int i=0; i<m; ++i){
        cin >> num;
        isBreak[num] = true;
    }
    
    // +- 로만 이동 한 경우
    int sub = n-100;
    if(sub<0) sub *= -1;
    int ans = sub;
    // 테케에서 보면 50만 이상 올라가서 빼도 된다.
    // 채널 이동 후 +- 한 경우
    for(int i=0; i<1000000; ++i){
        if(isAble(i)){
            int sub = n-i;
            if(sub<0) sub *= -1;
            if(sub>=ans) {
                if(i>=n) {
                    break;
                }
                else continue;
            }
            ans = min(ans, digitCount(i) + sub);
        }
    }    
    cout << ans;

    return 0;
}
