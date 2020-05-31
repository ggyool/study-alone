// two pointer


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
    int leftMostColumnWithOne(BinaryMatrix &binaryMatrix) {
        vector<int> v = binaryMatrix.dimensions();
        int r = v[0];
        int c = v[1];
        int ans = -1;
        int i = 0;
        int j = c-1;
        while(i<r && j>=0){
            if(binaryMatrix.get(i, j) == 1){
                if(ans==-1) ans = j;
                else ans = min(ans, j);
                --j;
            }
            else{
                i++;
            }
        }
        return ans;
    }
};