#include <iostream>
#include <string>
#include <cstring>
#include <algorithm>
#include <vector>
using namespace std;

class Solution {
public:
    string frequencySort(string s) {
        string ret;
        vector<pair<int, int>> v;
        int cnt[128];
        memset(cnt, 0, sizeof(cnt));
        int slen = s.size();
        for(int i=0; i<slen; ++i){
            ++cnt[s[i]];
        }
        for(int i=0; i<128; ++i){
            if(cnt[i]>0){
                v.push_back({-cnt[i], i});
            }
        }
        sort(v.begin(), v.end());
        int vlen = v.size();
        for(int i=0; i<vlen; ++i){
            int clen = -v[i].first;
            for(int j=0; j<clen; ++j){
                ret.push_back((char)v[i].second);
            }
        }
        return ret;
    }
};