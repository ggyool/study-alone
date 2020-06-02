#include <iostream>
#include <algorithm>
#include <vector>
#include <stack>
#include <cstring>
using namespace std;

// 사각형의 높이에 의미를 두어
// 큰것만 남겨놓는 stack 사용
// 오른쪽부터 한 번, 왼쪽부터 한 번 총 두 번 해야함 
typedef long long ll;
int n;
vector<ll> v;

ll leftSolve(){
    ll ret = 0;
    stack<int> stk;
    ll h,w;
    for(int i=0; i<n; ++i){
        // 같으면 스택에 넣어야 한다.
        while(!stk.empty() && v[stk.top()] > v[i]){
            h = v[stk.top()];
            stk.pop();
            if(stk.empty()) w = i;
            else w = i-stk.top()-1;
            ret = max(ret, w*h);
        }
        stk.push(i);
    }
    while(!stk.empty()){
        h = v[stk.top()];
        stk.pop();
        if(stk.empty()) w = n;
        else w = n-stk.top()-1;
        ret = max(ret, w*h);
    }
    return ret;
}


ll rightSolve(){
    ll ret = 0;
    stack<int> stk;
    ll h,w;
    for(int i=0; i<n; ++i){
        // 같으면 스택에 넣어야 한다.
        while(!stk.empty() && v[stk.top()] > v[n-1-i]){
            h = v[stk.top()];
            stk.pop();
            if(stk.empty()) w = i;
            else w = i-stk.top()-1;
            ret = max(ret, w*h);
        }
        stk.push(i);
    }
    while(!stk.empty()){
        h = v[stk.top()];
        stk.pop();
        if(stk.empty()) w = n;
        else w = n-stk.top()-1;
        ret = max(ret, w*h);
    }
    return ret;
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    while(true){
        cin >> n;
        if(n==0) break;
        v.clear();
        for(int i=0; i<n; ++i){
            ll num;
            cin >> num;
            v.push_back(num);
        }
        cout << leftSolve() << '\n';
    }
    return 0;
}

