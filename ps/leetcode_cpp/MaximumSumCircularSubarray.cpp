#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

class Solution {
public:
    const int INF = (int)1e9;
    int maxSubarraySumCircular(vector<int>& v) {
        // - o o o - - - 
        // o o - - - o o
        // 이런 두 가지 경우 나눠서 생각
        // lv : v[0] 포함 i까지 max
        // rv : v[len-1] 포함 i까지 max 
        // mv : ?~i max
        vector<int> lv, rv, mv;
        int len = v.size();
        lv = vector<int> (len, -INF);
        rv = vector<int> (len, -INF);
        mv = vector<int> (len, -INF);
        lv[0] = v[0];
        rv[len-1] = v[len-1];
        int lsum = v[0];
        int rsum = v[len-1];
        for(int i=1; i<len; ++i){
            lsum += v[i];
            rsum += v[len-1-i];
            lv[i] = max(lv[i-1], lsum);
            rv[len-1-i] = max(rv[len-i], rsum);
        }
        // circular 하지 않은 경우
        int ret = v[0];
        mv[0] = v[0];
        for(int i=1; i<len; ++i){
            mv[i] = max(v[i], mv[i-1] + v[i]);
            ret = max(ret, mv[i]);
        }
        // circular 한 경우
        for(int i=0; i<len-2; ++i){
            ret = max(ret, lv[i]+rv[i+2]);
        }
        return ret;
    }  
};

int main(void){

    vector<int> v = {5,-3,5};
    Solution sol;
    cout << sol.maxSubarraySumCircular(v);
    return 0;
}