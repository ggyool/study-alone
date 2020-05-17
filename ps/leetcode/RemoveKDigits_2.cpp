#include <iostream>
#include <vector>
#include <queue>
#include <stack>
#include <algorithm>
using namespace std;


class Solution {
public:
    stack<char> stk;
    string removeKdigits(string s, int k) {
        int len = s.size();
        for(int i=0; i<len; ++i){
            char c = s[i];
            while(k>0 && !stk.empty() && stk.top() > c){
                stk.pop();
                k--;
            }
            if(!stk.empty() || c!='0') stk.push(c);
        }
        while(!stk.empty() && k>0){
            k--;
            stk.pop();
        }
        if(stk.empty()) return "0";
        string ret;
        while(!stk.empty()){
            ret.push_back(stk.top());
            stk.pop();
        }
        reverse(ret.begin(), ret.end());
        return ret;
    }
};