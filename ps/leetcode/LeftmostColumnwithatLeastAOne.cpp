#include <algorithm>
#include <vector>
#include <iostream>
using namespace std;


class BinaryMatrix {
    public:
      int get(int row, int col);
      vector<int> dimensions();
 };
 

class Solution {
public:
    int upperBound(BinaryMatrix &BinaryMatrix, int row, int c){
        int left = 0, right = c;
        int mid;
        while(left<right){
            int mid = left + (right-left)/2;
            if(BinaryMatrix.get(row, mid)==0){
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }
        return right;
    }
    int leftMostColumnWithOne(BinaryMatrix &binaryMatrix) {
        vector<int> v = binaryMatrix.dimensions();
        int r = v[0];
        int c = v[1];
        int ans = -1;
        for(int i=0; i<r; ++i){
            int idx = upperBound(binaryMatrix, i, c);
            if(idx!=c){
                if(ans==-1) ans = idx;
                else ans = min(ans, idx);
            }
        }
        return ans;
    }
};