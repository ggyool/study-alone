#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    // [0,0,1,1,1,2,2,3,3,4]
    int removeDuplicates(vector<int>& arr) {
        // i : 넣을 위치
        // j : 탐색
        int len = arr.size();
        if(len==0) return 0;
        int i = 0;
        int ret = 1;
        for(int j=0; j<len; ++j){
            if(arr[i] != arr[j]){
                arr[++i] = arr[j];
                ++ret;
            }
        }
        return ret;
    }
};
int main(void){

    return 0;
}