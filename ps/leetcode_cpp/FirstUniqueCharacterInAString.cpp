#include <iostream>
#include <cstring>
#include <vector>
using namespace std;

class Solution {
public:
    int firstUniqChar(string s) {
        vector<int> cnt(26, 0);
        int len = s.size();
        for(int i=0; i<len; ++i){
            char c = s[i];
            ++cnt[c-'a'];
        }
        for(int i=0; i<len; ++i){
            char c = s[i];
            if(cnt[c-'a'] == 1) return i;
        }
        return -1;
    }
};