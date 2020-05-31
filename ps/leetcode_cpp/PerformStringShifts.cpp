#include <deque>
#include <vector>
#include <string>
#include <algorithm>
using namespace std;

class Solution {
public:
    string stringShift(string s, vector<vector<int>>& shift) {
        int slen = s.size();
        deque<char> dq;
        for(int i=0; i<slen; ++i){
            dq.push_back(s[i]);
        }   
        int tlen = shift.size();
        for(int t=0; t<tlen; ++t){
            bool dir = shift[t][0];
            int amount = shift[t][1];
            for(int i=0; i<amount; ++i){
                if(dir==0) {
                    dq.push_back(dq.front() );
                    dq.pop_front();
                }
                else{
                    dq.push_front(dq.back());
                    dq.pop_back();
                }
            }
        }   
        string ret = "";
        while(!dq.empty()) {
            ret.push_back(dq.front());
            dq.pop_front();
        }
        return ret;
    }
};