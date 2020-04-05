#include <iostream>
#include <cstring>
#include <vector>
using namespace std;


class Solution {
public:
    int maxProfit(vector<int>& v) {
        int len = v.size();
        int ret = 0;
        if(len==0) return 0;
        for(int i=1; i<len; ++i){
            if(v[i]-v[i-1] > 0){
                ret += v[i]-v[i-1];
            }
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




    
