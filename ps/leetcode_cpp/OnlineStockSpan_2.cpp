#include <string>
#include <cstring>
#include <algorithm>
#include <stack>
using namespace std;


class StockSpanner {
public:
    // 내림차순으로 val, weight
    stack<pair<int, int>> stk;
    StockSpanner() {
        
    }
    int next(int price) {
        pair<int, int> p = {price, 1};
        while(!stk.empty() && stk.top().first<=price){
            p.second += stk.top().second;
            stk.pop();
        }
        stk.push(p);
        return p.second;
    }
};