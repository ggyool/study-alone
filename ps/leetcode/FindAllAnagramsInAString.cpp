#include <iostream>
#include <vector>
#include <queue>
#include <stack>
#include <algorithm>
using namespace std;

class Solution {
public:
    bool isSame(vector<int>& va, vector<int> &vb){
        int len = va.size();
        for(int i=0; i<len; ++i){
            if(va[i] != vb[i]) return false;
        }
        return true;
    }
    vector<int> findAnagrams(string s, string p) {
        int slen = s.size();
        int plen = p.size();
        if(plen>slen) return {};
        vector<int> ret;
        vector<int> pAlpha(26, 0);
        vector<int> sAlpha(26, 0);
        for(int i=0; i<plen; ++i){
            ++pAlpha[p[i] - 'a'];
        }
        for(int i=0; i<plen; ++i){
            ++sAlpha[s[i] - 'a'];
        }
        if(isSame(sAlpha, pAlpha)) ret.push_back(0);
        
        for(int i=plen; i<slen; ++i){
            --sAlpha[s[i-plen]-'a'];
            ++sAlpha[s[i]-'a'];
            if(isSame(sAlpha, pAlpha)) ret.push_back(i-plen+1);
        }
        return ret;
    }
};