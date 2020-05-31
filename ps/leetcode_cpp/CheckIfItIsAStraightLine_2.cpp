#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


// babo
// y1/x1 == y2/x2
// y1*x2 == y2*x1

class Solution {
public:
    bool checkStraightLine(vector<vector<int>>& v) {
        int dx = v[1][0] - v[0][0];
        int dy = v[1][1] - v[0][1];
        int vlen = v.size();
        for(int i=2; i<vlen; ++i){
            int cx = v[i][0] - v[0][0];
            int cy = v[i][1] - v[0][1];
            if(cx*dy != cy*dx) return false;
        }
        return true;
    }
};