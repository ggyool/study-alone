#include <vector>
#include <algorithm>
#include <iostream>
#include <climits>
using namespace std;

// solution 만 제출
bool isBadVersion(int version){
    return true;
}

class Solution {
public:
    int firstBadVersion(int n) {
        // 무조건 있으니까 n을 넣었음
        return lowerBound(1, n);
    }
    int lowerBound(int left, int right){
        int mid;
        while(left<right){
            mid = left + (right-left)/2;
            if(isBadVersion(mid)==false){
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }
        return right;
    }
};