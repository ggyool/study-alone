#include <iostream>
#include <stack>
using namespace std;

int n,b;
stack<char> stk;

int main(void){
    cin >> n >> b;

    while(n!=0){
        int r = n % b;
        n /= b;
        if(r < 10) stk.push(r + '0');
        else stk.push(r - 10 + 'A');
    }
    while(!stk.empty()){
        cout << stk.top();
        stk.pop();
    }

    return 0;
}