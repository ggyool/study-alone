#include <vector>
#include <iostream>
#include <algorithm>
#include <queue>
using namespace std;

//46340**2 == 2147395600
class Solution {
public:
    bool isPerfectSquare(int num) {
        int left = 1;
        int right = 46340;
        int mid;
        if(right*right<num) return false;
        while(left<=right){
            mid = left + (right-left)/2;
            if(mid*mid>num) right=mid-1;
            else if(mid*mid<num) left=mid+1;
            else return true;
        }
        return false;
    }
};