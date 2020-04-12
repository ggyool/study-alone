#include <iostream>
#include <stack>
#include <string>
#include <map>
using namespace std;


class MinStack {
private:
    stack<int> stk;
    map<int, int> mp;
public:
    MinStack() {
        
    }
    
    void push(int x) {
        stk.push(x);
        ++mp[x];
    }
    
    void pop() {
        int x = stk.top();
        stk.pop();
        --mp[x];
        if(mp[x] == 0)
            mp.erase(x);
    }
    
    int top() {
        return stk.top();
    }
    
    int getMin() {
        return mp.begin()->first;
    }
};

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack* obj = new MinStack();
 * obj->push(x);
 * obj->pop();
 * int param_3 = obj->top();
 * int param_4 = obj->getMin();
 */