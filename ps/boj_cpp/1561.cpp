#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <cstring>
using namespace std;

typedef long long ll;
int n,m;
vector<int> v;

ll counting(ll time){
    ll tot = 0;
    for(int i=0; i<m; ++i){
        tot += 1 + time/v[i];
    }
    return tot;
}

bool isAble(ll time){
    return counting(time)>=n;
}

// n이 22에서 딱 맞춰지리란 보장이 없고 21->23 이 될 수도 
// 명 수를 구해서 뒤에서 부터 몇 번째 인덱스인지 찾으면 된다.
int solve(){
    // 실수 하기 좋다
    if(n<=m) return n-1;
    ll left = 1;
    ll right = 2*30*(ll)1e9;
    ll mid;
    ll lb = right;
    while(left<=right){
        mid = left + (right-left)/2;
        if(isAble(mid)){
            right = mid - 1;
            lb = min(lb, mid);
        }
        else{
            left = mid+1;
        }
    }
    ll findCnt = counting(lb)-n;
    ll cnt = 0;
    for(int i=m-1; i>=0; --i){
        if(lb%v[i] == 0){
            if(cnt==findCnt) return i;
            ++cnt;
        }
    }
    return -1;
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n >> m;
    for(int i=0; i<m; ++i){
        int num;
        cin >> num;
        v.push_back(num);
    }
    cout << solve() + 1;
    return 0;
}

