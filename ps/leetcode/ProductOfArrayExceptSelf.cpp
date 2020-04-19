#include <deque>
#include <vector>
#include <string>
#include <algorithm>
using namespace std;


class Solution {
public:
    vector<int> productExceptSelf(vector<int>& v) {
        int len = v.size();
        vector<int> ret(len, 1);

        int leftMul = v[0];
        int rightMul = v[len-1];
        for(int i=1; i<len; ++i){
            ret[i] *= leftMul;
            ret[len-1-i] *= rightMul;
            leftMul *= v[i];
            rightMul *= v[len-1-i];
        }
        return ret;
    }
};