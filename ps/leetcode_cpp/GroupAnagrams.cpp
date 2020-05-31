#include <string>
#include <algorithm>
#include <vector>
#include <unordered_map>
using namespace std;

class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        unordered_map<string, vector<string>> mp;
        int slen = strs.size();
        for(int i=0; i<slen; ++i){
            string s = strs[i];
            sort(s.begin(), s.end());
            string key = s;
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
        unordered_map<string, vector<string>>::iterator it;
        for(it = mp.begin(); it!=mp.end(); ++it){
            ret.push_back(it->second);
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