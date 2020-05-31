#include <iostream>
using namespace std;

/*
12,15
01100
01101
01110
01111
*/
// 생각..생각 해서 규칙 찾아서 품
class Solution {
public:
    int rangeBitwiseAnd(int m, int n) {
        long long i=1;
        while(m!=n){
            i*=2;
            m/=2;
            n/=2;
        }
        return i*m;
    }
};


int main(void){
    Solution sol;
    cout << sol.rangeBitwiseAnd(0,3);
       
    return 0;
}