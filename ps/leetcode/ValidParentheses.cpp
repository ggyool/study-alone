#include <iostream>
#include <stack>
using namespace std;
class Solution {
public:
    bool isValid(string s) {
        stack<char> stk;
        int slen = s.size();
        for(int i=0; i<slen; ++i){
            char c = s[i];
            if(c=='(' || c=='[' || c=='{'){
                stk.push(c);
            }
            else {
                if(stk.empty()) return false;
                if(c==')' && stk.top()=='(') stk.pop();
                else if(c==']' && stk.top()=='[') stk.pop();
                else if(c=='}' && stk.top()=='{') stk.pop();
                else return false;
            }
        }
        return stk.empty();
    }
};