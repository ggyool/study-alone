#include <deque>
#include <vector>
#include <string>
#include <algorithm>
#include <cstring>
using namespace std;



class Solution {
public:
    int search(vector<int>& v, int target) {
        if(v.size()==0) return -1;
        int left = 0;
        int right = v.size() - 1;
        return divide(left, right, target, v);
    }
    int divide(int left, int right, int target, vector<int> & v){
        if(left==right) return target==v[left]?left:-1;
        int mid = left + (right-left)/2;
        if(v[left] > v[right]){
            int res1 = divide(left, mid, target, v);
            int res2 = divide(mid+1, right, target, v);
            if(res1!=-1) return res1;
            if(res1!=-2) return res2;
            return -1;
        } 
        else{
            return binarySearch(left, right, target, v);
        }
    }
    int binarySearch(int left, int right, int target, vector<int>& v){
        int ret = -1;
        int mid;
        while(left<=right){
            mid = left + (right-left)/2;
            if(target==v[mid]){
                return mid;
            }
            else if(target>v[mid]){
                left = mid+1;
            }
            else {
                right = mid-1;
            }
        }
        return ret;
    }
};