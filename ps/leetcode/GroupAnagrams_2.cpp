#include <string>
#include <algorithm>
#include <vector>
#include <unordered_map>
#include <iostream>
#include <cstring>
using namespace std;

class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        unordered_map<string, vector<string>> mp;
        int slen = strs.size();
        int arr[26];
        for(int i=0; i<slen; ++i){
            memset(arr, 0, sizeof(arr));
            for(char c : strs[i]){
                ++arr[c-'a'];
            }
            string key = "";
            for(int i=0; i<26; ++i){
                string tmp = to_string(arr[i]);
                int tlen = tmp.size();
                for(int j=0; j<tlen; ++j){
                    key.push_back(tmp[j]);
                }
                key.push_back(',');
            }
            auto iter = mp.find(key);
            if(iter==mp.end()){
                vector<string> v = {strs[i]};
                mp.insert({key, v});
            }
            else{
                iter->second.push_back(strs[i]);
            }
        }
        vector<vector<string>> ret;
        for(auto& it : mp){
            ret.push_back(it.second);
        }
        return ret;
    }
};


int main(void){
    
    Solution sol = Solution();
    vector<string> v = {"eat", "tea", "tan", "ate", "nat", "bat"};
    sol.groupAnagrams(v);
    
    return 0;
}