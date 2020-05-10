#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

int gcd(int a, int b){
    if(b==0) return a;
    return gcd(b, a%b);
}

class Solution {
public:
    bool checkStraightLine(vector<vector<int>>& v) {
        int len = v.size();
        if(len==1) return true;
        sort(v.begin(), v.end());
        int dir;
        int ix = v[1][0] - v[0][0];
        int iy = v[1][1] - v[0][1];
        if(iy==0) dir = 0;
        else if(iy>0) dir = 1;
        else dir = -1;
        iy = abs(iy);
        int gcdn = gcd(ix,iy);
        if(dir!=0){
            ix /= gcdn;
            iy /= gcdn;
        }
        for(int i=2; i<len; ++i){
            int cx = v[i][0] - v[0][0];
            int cy = v[i][1] - v[0][1];
            int cdir;
            if(cy==0) cdir = 0;
            else if(cy>0) cdir=1;
            else cdir=-1;
            cy = abs(cy);
            if(cdir==0){
                if(dir==0) continue;
                else return false;
            }
            if(dir!=cdir) return false;
            int g = gcd(cx,cy);
            cx /= g;
            cy /= g;
            if(cx!=ix || cy!=iy) return false;
        }
        return true;
    }
};


/*
class Solution {
public:
    bool checkStraightLine(vector<vector<int>>& coordinates) {
        
        int xdiff=abs(coordinates[1][0]-coordinates[0][0]);
        int ydiff=abs(coordinates[1][1]-coordinates[0][1]);
        int currx,curry;
        for(int i=2;i<coordinates.size();++i){
             currx=abs(coordinates[i][0]-coordinates[i-1][0]);
             curry=abs(coordinates[i][1]-coordinates[i-1][1]);
             if(currx*ydiff!=curry*xdiff)  
                 return false;
        }
        
        return true;
    }
};
*/