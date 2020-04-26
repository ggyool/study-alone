#include <algorithm>
#include <vector>
#include <iostream>
#include <unordered_map>
#include <queue>
using namespace std;

class Solution {
public:
    bool canJump(vector<int>& v) {
        int n = v.size();
        int maxIdx = 0; // 최대 탐색 범위
        for(int i=0; i<n-1; ++i){
            if(i<=maxIdx)
                maxIdx = max(maxIdx, i+v[i]);
        }
        return maxIdx>=n-1;
    }
};