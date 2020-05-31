#include <iostream>
#include <cstring>
#include <vector>
using namespace std;

class Solution {
public:
    int findComplement(int num) {
        int ret = 0;
        long long sq = 1;
        while(num){
            if((num & 1) == 0){
                ret += sq;
            }
            num >>= 1;
            sq *= 2;
        }
        return ret;
    }
};

int main(void){
    Solution sol;
    cout << sol.findComplement(2147483647);
    return 0;
}