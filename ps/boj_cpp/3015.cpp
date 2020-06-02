#include <iostream>
#include <algorithm>
#include <vector>
#include <stack>
#include <cstring>
using namespace std;

typedef long long ll;

int n;
vector<int> v;

/*
2 4 1 2 e 5 1
stk		 pair
4       2,4
4 1     4,1
4 2		 1,2  4,2
4 e		 4, e
5		 e,5 2,e 2,5 4,5
5 1     5.1
*/

// 큰게 나오면 스택을 비운다. (왼쪽은 버린다)
// 기본 아이디어는 단순한데
// 같은 높이의 처리 때문에 까다로워지는 문제
// 같은게 연속으로 오면 second 1씩 더한다.
// 같은거 뺄 생각 안하면 구현어렵다.
ll solve(){
    ll ret = 0;
    // idx, sameCount
    stack<pair<int, int>> stk;
    for(int i=0; i<n; ++i){ 
        if(stk.empty()){
            stk.push({i, 1});
        }
        else{
            int seqCnt = 1;
            while(!stk.empty() && v[stk.top().first]<=v[i]){
                ret += stk.top().second;
                if(v[stk.top().first] == v[i]) seqCnt = stk.top().second + 1;
                stk.pop();
            }
            if(!stk.empty()) ++ret;
            stk.push({i, seqCnt}); 
            
        }
    }
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

