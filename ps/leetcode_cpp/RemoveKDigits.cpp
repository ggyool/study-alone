#include <iostream>
#include <vector>
#include <queue>
using namespace std;

struct Digit{
    int idx, val;
    Digit(int _idx, int _val) : idx(_idx), val(_val) {}
    bool operator<(const Digit &ref) const{
        if(val==ref.val) return idx>ref.idx;
        return val > ref.val;
    }
};
class Solution {
public:
    priority_queue<Digit> pq;
    int left = -1;
    string removeKdigits(string s, int k) {
        string ret;
        int len = s.size();
        int pick = len - k;
        for(int i=0; i<len; ++i){
            if(pick==0) break;
            pq.push(Digit(i, s[i]-'0'));
            if(len-i == pick){
                while(!pq.empty()){
                    int idx = pq.top().idx;
                    int val = pq.top().val;
                    pq.pop();
                    if(idx<=left) continue;
                    left = idx;
                    --pick;
                    if(ret.empty() && val==0) break;
                    ret.push_back(val+'0');
                    break;
                }
            }
        }
        return ret.empty()?"0":ret;
    }
};