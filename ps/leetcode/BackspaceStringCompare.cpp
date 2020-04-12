#include <iostream>
#include <vector>
#include <string>
using namespace std;

class Solution {
public:
    bool backspaceCompare(string S, string T) {
        int slen = S.size();
        int tlen = T.size();
        int i = slen-1;
        int j = tlen-1;
        int scnt = 0, tcnt = 0;
        while(i>=0 || j>=0){
            char sc = '#', tc = '#';
            while(i>=0){
                sc = S[i];
                --i;
                if(sc=='#') {
                    ++scnt;
                }
                else {
                    if(scnt==0) break;
                    else {
                        sc = '#';
                        --scnt;
                    }    
                }
            }
            while(j>=0){
                tc = T[j];
                --j;
                if(tc=='#') {
                    ++tcnt;
                }
                else{
                    if(tcnt==0) break;
                    else {
                        tc = '#';
                        --tcnt;
                    }
                }
            }
            if(sc!=tc) return false;
        }
        return true;
    }
};

int main(void){
    Solution sol = Solution();
    sol.backspaceCompare("ab##"
,"c#d#");

    return 0;
}