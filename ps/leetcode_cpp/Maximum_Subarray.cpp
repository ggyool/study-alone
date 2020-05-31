#include <iostream>
#include <cstring>
#include <vector>
using namespace std;

class Solution {
public:
    int maxSubArray(vector<int>& v) {
        int len = v.size();
        int ret = v[0];
        int bef = v[0];
        for(int i=1; i<len; ++i){
            if(bef<0){
                bef = v[i];
            }else{
                bef += v[i];
            }
            ret = max(ret, bef);
        }
        return ret;
    }
};

int main(void){
    int n;
    cin >> n;
    Solution sol = Solution();
    
    
    return 0;
}




    
