#include <iostream>
#include <stack>
#include <algorithm>
#include <climits>
using namespace std;


class MinStack {
private:
    stack<pair<int, int>> stk;
public:
    MinStack() {
        
    }
    void push(int x) {
        stk.push({x, min(getMin(), x)});
    }
    void pop() {
        stk.pop();
    }
    
    int top() {
        return stk.top().first;
    }
    
    int getMin() {
        if(stk.size() == 0) return INT_MAX;
        else return stk.top().second;
    }
};


int main(void){
    MinStack* obj = new MinStack();
    obj->push(2);
    obj->push(-2);
    obj->push(-3);
    obj->pop();
    cout << obj->getMin();
    
    return 0;
}