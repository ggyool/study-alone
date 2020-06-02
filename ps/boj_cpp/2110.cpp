#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <cstring>
using namespace std;

typedef long long ll;
int n,c;
vector<int> v;

bool isAble(int val){
    // 최대한 많이 놓으면 좋으므로, 왼쪽부터 놓을 수 있으면 놓는다.
    int cnt = 1;
    int bef = v[0];
    for(int i=1; i<n; ++i){
        if(v[i]-bef >= val){
            ++cnt;
            bef = v[i];
        }
    }
    return cnt>=c;
}

int solve(){
    int left = 1;
    int right = int(1e9);
    int mid;
    int ret = 0;
    while(left<=right){
        mid = left + (right-left)/2;
        // 해당 간격이상으로 c개 설치 가능한지
        if(isAble(mid)){
            left = mid + 1;
            ret = max(ret, mid);
        }
        else{
            right = mid - 1;
        }
    }
    return ret;
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n >> c;
    for(int i=0; i<n; ++i){
        int num;
        cin >> num;
        v.push_back(num);
    }
    sort(v.begin(), v.end());
    cout << solve();
    return 0;
}

