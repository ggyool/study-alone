#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    int countElements(vector<int>& arr) {
        int len = arr.size();
        vector<int> cnt(1001,0);
        for(int i=0; i<len; ++i){
            ++cnt[arr[i]];
        }
        int ret = 0;
        for(int i=0; i<=999; ++i){
            if(cnt[i+1]>0) ret += cnt[i];
        }
        return ret;
    }
};