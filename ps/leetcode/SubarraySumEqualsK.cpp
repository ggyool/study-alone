#include <algorithm>
#include <vector>
#include <iostream>
using namespace std;


class Solution {
public:
    int subarraySum(vector<int>& v, int k) {
        int n = v.size();
        vector<int> psum(n, 0);
        psum[0] = v[0];
        for(int i=1; i<n; ++i){
            psum[i] = psum[i-1]+v[i];
        }
        
        int ans = 0;
        for(int i=0; i<n; ++i){
            for(int j=i; j<n; ++j){
                cout << i << ' ' << j << ' ' <<  psum[j]-psum[i]+v[i] << '\n';
                if(psum[j]-psum[i]+v[i] == k){
                    ++ans;
                }
            }
        }
        return ans;
    }
};