#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

class Solution {
public:
    static bool cmp(const vector<int>& aref, const vector<int> &bref){
        return aref[0] < bref[0];
    }
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        vector<vector<int>> ret;
        int len = intervals.size();
        if(len<=1) return intervals;
        sort(intervals.begin(), intervals.end(), cmp);
        
        vector<int> cur = intervals[0];
        for(int i=0; i<len; ++i){
            int start = intervals[i][0];
            int end = intervals[i][1];
            if(start<=cur[1]){
                if(end>cur[1]) cur[1] = end;
            }
            else{
                ret.push_back(cur);
                cur[0] = start;
                cur[1] = end;
            }
        }   
        ret.push_back(cur);
        return ret;
    }
};

