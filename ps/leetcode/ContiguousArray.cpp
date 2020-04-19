#include <vector>
#include <algorithm>
#include <iostream>
#include <unordered_map>
using namespace std;

class Solution {
public:
    int findMaxLength(vector<int>& v) {
        // 1이면 +1, 0이면 -1
        // 해당 key 가 처음 나오는 idx
        unordered_map<int,int> mp;
        mp.insert({0, -1});
        int ret = 0;
        int len = v.size();
        int sum = 0;
        for(int i=0; i<len; ++i){
            if(v[i]) ++sum;
            else --sum;
            auto it = mp.find(sum);
            if(it== mp.end()){
                mp.insert({sum, i});
            }
            else{
                ret = max(ret, i-(it->second));
            }
        }
        return ret;
    }
};

int main(void){
    Solution sol = Solution();
    vector<int> v = {0,1,0,1};
    -1 0 -1 0
    cout << sol.findMaxLength(v);

    return 0;
}