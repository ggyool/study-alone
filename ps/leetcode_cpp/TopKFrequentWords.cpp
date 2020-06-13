#include <iostream>
#include <vector>
#include <unordered_map>
#include <string>
#include <algorithm>
using namespace std;




class Info{
public:
    string word;
    int cnt;
    Info(string _word, int _cnt){
        word = _word, cnt = _cnt;
    }
    bool operator<(const Info &ref) const{
        if(cnt == ref.cnt) return word<ref.word;
        return cnt > ref.cnt;
    }
};

class Solution {
public:
    vector<string> topKFrequent(vector<string>& words, int k) {
        unordered_map<string, int> mp;
        int len = words.size();
        for(int i=0; i<len; ++i){
            ++mp[words[i]];
        }
        vector<Info> v;
        for(auto it = mp.begin(); it!=mp.end(); ++it){
            v.push_back(Info(it->first, it->second)); 
        }
        sort(v.begin(), v.end());
        vector<string> ret;
        for(int i=0; i<k; ++i){
            ret.push_back(v[i].word);
        }
        return ret;
    }
};

int main(void){

    return 0;
}