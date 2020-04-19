#include <vector>
#include <algorithm>
using namespace std;

class Solution {
public:
    int findMaxLength(vector<int>& v) {
        int len = v.size();
        int cnt = 0;
        for(int i=0; i<len; ++i){
            if(v[i]) ++cnt;
        }
        int i = 0, j = len-1;
        while(i<j){
            if(cnt*2 == j-i+1) return cnt*2;
            if(v[i] == v[j]){
                if(v[i] == 1) --cnt;
                ++i; 
            }
            else{
                // 1이 많으면
                if(cnt*2>j-i+1){
                    if(v[i]==1) ++i;
                    else --j;
                    --cnt;
                }
                else{
                    if(v[i]==0) ++i;
                    else --j;
                }
            }
        }
        return 0;
    }
};