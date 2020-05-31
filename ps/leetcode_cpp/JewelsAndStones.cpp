#include <vector>
#include <algorithm>
#include <iostream>
#include <string>
using namespace std;


class Solution {
public:
    int numJewelsInStones(string J, string S) {
        // small
        vector<bool> sv(26, 0);
        vector<bool> bv(26, 0);
        for(char &c: J){
            if(c>='a'){
                sv[c-'a'] = true;
            }
            else{
                bv[c-'A'] = true;
            }
        }
        int ret = 0;
        for(char &c : S){
            if(c>='a'){
                ret += sv[c-'a'];
            }
            else{
                ret += bv[c-'A'];
            }
        }
        return ret;
    }
};