#include <iostream>
#include <string>
#include <vector>
using namespace std;
class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        string ret = "";
        int vlen = strs.size();
        if(vlen==0) return ret;
        string fs = strs[0];
        int flen = fs.size();
        for(int i=0; i<flen; ++i){
            char c = fs[i];
            bool isSame = true;
            for(int j=1; j<vlen; ++j){
                if(i>=strs[j].size() || c!=strs[j][i]){
                    isSame = false;
                    break;
                }
                
            }
            if(isSame) ret += c;
            else break;
        }
        return ret;
    }
};