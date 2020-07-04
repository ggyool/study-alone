#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    // [1,0,2,3,0,4,5,0]
    void duplicateZeros(vector<int>& arr) {
        int len = arr.size();
        int cnt = 0;
        int end = 0;
        for(int i=0; i<len; ++i){
            if(arr[i]==0) cnt += 2;
            else ++cnt;
            if(cnt>=len) {
                end = i;
                break;
            }
        }
        // cnt > len 마지막이 0이고 하나만 넣어야하는 경우
        int j = len - 1;
        if(cnt>len) {
            arr[j--] = 0;
            --end;
        }
        for(int i=end; i>=0; --i){
            if(arr[i]==0){
                arr[j--] = 0;
                arr[j--] = 0;
            }
            else{
                arr[j--] = arr[i];
            }
        }
    }
};


int main(void){

    return 0;
}