#include <string>
#include <cstring>
#include <algorithm>
#include <stack>
#include <deque>
using namespace std;

class StockSpanner {
public:
    stack<int> stk;
    deque<int> dq;
    StockSpanner() {

    }
    int next(int price) {
        if(!dq.empty() && dq.back()>price){
            while(!dq.empty()){
                stk.push(dq.front());
                dq.pop_front();
            }
        }
        else{
            while(!stk.empty()){
                if(stk.top()<=price){
                    dq.push_front(stk.top());
                    stk.pop();
                }else{
                    break;
                }
            }
        }
        dq.push_back(price);
        return dq.size();
    }
};

