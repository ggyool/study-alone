#include <string>
#include <cstring>
#include <algorithm>
using namespace std;

class Solution {
public:
    int wrr[26], srr[26];
    bool isSame(){
        for(int i=0; i<26; ++i){
            if(wrr[i] != srr[i]) return false;
        }
        return true;
    }
    bool checkInclusion(string w, string s) {
        memset(wrr, 0, sizeof(wrr));
        memset(srr, 0, sizeof(srr));
        int wlen = w.size();
        int slen = s.size();
        if(wlen>slen) return false;
        for(int i=0; i<wlen; ++i){
            ++wrr[w[i]-'a'];
            ++srr[s[i]-'a'];
        }
        if(isSame()) return true;
        for(int i=1; i<=slen-wlen; ++i){
            --srr[s[i-1]-'a'];
            ++srr[s[i-1+wlen]-'a'];
            if(isSame()) return true;
        }
        return false;
    }
};