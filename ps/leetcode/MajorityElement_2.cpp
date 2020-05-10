#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

// genius?

class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int len = nums.size();
        int cnt = 1;
        int cur = nums[0];
        for(int i=1; i<len; ++i){
            if(cnt==0){
                cur = nums[i];
            }
            if(cur==nums[i]){
                ++cnt;
            }
            else{
                --cnt;
            }
        }
        return cur;
    }
};

