#include <vector>
using namespace std;

class Solution {
public:
    void sortColors(vector<int>& nums) {
        int oneCnt = 0;
        int twoCnt = 0;
        int len = nums.size();
        for(int i=0; i<len; ++i){
            if(nums[i] == 1){
                ++oneCnt;
            }else if(nums[i]==2){
                ++twoCnt;
            }
            nums[i] = 0;
        }
        for(int i=0; i<len; ++i){
            if(twoCnt>0){
                nums[len-1-i] = 2;
                --twoCnt;
            }else if(oneCnt>0){
                nums[len-1-i] = 1;
                --oneCnt;
            }
        }
    }
};