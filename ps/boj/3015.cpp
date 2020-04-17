#include <iostream>
#include <algorithm>
#include <vector>
#include <stack>
#include <cstring>
using namespace std;

typedef long long ll;

int n;
vector<int> v;


// 큰게 나오면 스택을 비운다. (왼쪽은 버린다)
// 기본 아이디어는 단순한데
// 같은 높이의 처리 때문에 까다로워지는 문제
// 같은게 연속으로 오면 second 1씩 더한다.
ll solve(){
    ll ret = 0;
    // idx, sameCount
    stack<pair<int, int>> stk;
    for(int i=0; i<n; ++i){ 
        if(i!=0) ++ret;
        if(stk.empty()){
            stk.push({i, 0});
        }
        else{
            while(!stk.empty() && v[stk.top().first]<v[i]){
                if(i-stk.top().first > 1) ++ret;
                if(stk.top().second>=2) ret += stk.top().second;
                stk.pop();
            }
            int seqCnt = 0;
            if(!stk.empty()) {
                if(v[stk.top().first] == v[i])
                    seqCnt = stk.top().second+1;
            }
            stk.push({i, seqCnt});
        }
    }

    // while(!stk.empty()){
    //     cout << v[stk.top().first] << ' ';
    //     stk.pop();
    // }
    return ret;
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n;
    int num;
    for(int i=0; i<n; ++i){
        cin >> num;
        v.push_back(num);
    }
    cout << solve();
    return 0;
}

