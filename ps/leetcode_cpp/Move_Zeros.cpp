#include <iostream>
#include <cstring>
#include <vector>
using namespace std;
 

class Solution {
public:
    void moveZeroes(vector<int>& v) {
        // int i=0, j=0;
        // int len = v.size();
        // while(j<len){
        //     if(v[j]==0){
        //         ++j;
        //     }
        //     // i==0 j!=0
        //     else if(v[i]==0){
        //         v[i] = v[j];
        //         v[j] = 0;
        //         ++i;
        //     }
        //     else{
        //         ++i, ++j;
        //     }
        // }
        int j = 0;
        int len = v.size();
        for(int i=0; i<len; ++i){
            if(v[i]!=0){
                v[j++] = v[i];
            }
        }
        for(int i=j; i<len; ++i){
            v[i] = 0;
        }    
    }
};


int main(void){
    int n;
    cin >> n;
    Solution sol = Solution();
    
    
    return 0;
}




    
