#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

// 소인수 분해하여 모든 소인수들이 짝수제곱인지..
// 이분탐색인데 왜이렇게 풀었지?

class Solution {
public:
    bool isPerfectSquare(int num) {
        int fnum = num;
        if(num==1) return true;
        vector<int> v;
        int i = 2;
        for(long long i=2; i*i<=fnum; ++i){
            int cnt = 0;
            while(num>1 && num%i==0){
                num /= i;
                ++cnt;
            }
            if(cnt>0) v.push_back(cnt);
        }
        if(num!=1) return false;
        int vlen = v.size();
        for(int i=0; i<vlen; ++i){
            if(v[i]&1) return false;
        }
        return true;
    }
};

int main(void){

    Solution sol;
    sol.isPerfectSquare(104976);
    
}