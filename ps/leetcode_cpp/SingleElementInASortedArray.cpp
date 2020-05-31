#include <iostream>
#include <vector>
#include <queue>
using namespace std;


class Solution {
public:
    int getRight(vector<int> &v, int mid){
        if(mid+1 >= v.size()) return -1;
        return v[mid+1];
    }
    int getLeft(vector<int> &v, int mid){
        if(mid-1 < 0) return -1;
        return v[mid-1];
    }
    // 같은수가 짝홀 이면 아직 안나옴 (left=mid+1)
    // 홀짝이면 (right=mid-1)
    int singleNonDuplicate(vector<int>& v) {
        int left = 0;
        int right = v.size()-1;
        int mid;
        while(left<=right){
            mid = left + (right-left)/2;
            if(v[mid]==getLeft(v, mid)){
                if(mid&1) left=mid+1;
                else right=mid-2;
            }
            else if(v[mid]==getRight(v, mid)){
                if(mid&1) right=mid-1;
                else left=mid+2;
            }
            else{
                return v[mid];
            }
        }
        return -1;
    }
};