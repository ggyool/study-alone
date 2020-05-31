#include <algorithm>
#include <vector>
#include <iostream>
#include <unordered_map>
using namespace std;


class Solution {
public:
    // 1,2,3,4,1
    int subarraySum(vector<int>& v, int k) {
        unordered_map<int, int> mp;
        int n = v.size();
        int sum = 0;
        for(int i=0; i<n; ++i){
            sum += v[i];
            ++mp[sum];
        }
        sum = 0;
        int ans = 0;
        for(int i=0; i<n; ++i){
            sum += v[i];
            ans += mp[k];
            --mp[sum];
            k += v[i];
        }
        return ans;
    }
};
