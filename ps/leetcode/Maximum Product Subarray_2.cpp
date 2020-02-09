#include <algorithm>
#include <vector>
#include <iostream>
using namespace std;

typedef long long lld;

class Solution {
public:
    // 솔루션 코드 보았음 많은것이 축약되어있다.
    // * * * 0 * * * 0 * * * 0 
    // 0을 기준으로 조각내서 부분곱이 구해짐 
    // 어떤 * * *이 0이 없다고 가정하면
    // 왼쪽 끝이나 오른쪽 끝 중 하나를 반드시 포함한다.
    // 다 양수 - 당연히 왼쪽 오른쪽 포함
    // 음수가 짝수개 - 당연히 왼쪽 오른쪽 포함
    // 음수가 3개 이상의 홀수개
    // 5개라고 하면 4개포함이 최대값이므로 왼쪽처음~마지막 홀수전까지, 또는 오른쪽끝~처음 홀수 전까지 중 하나
    // 음수가 1개일때, 음수를 기준으로 왼쪽 양수들 또는 오른쪽 양수들
    int maxProduct(vector<int>& v) {
        int lsum = 1, rsum = 1;
        int ret = v[0];
        int len = v.size();
        for(int i=0; i<len; ++i){
            lsum *= v[i];
            rsum *= v[len-i-1];
            ret = max(ret, lsum);
            ret = max(ret, rsum);
            if(lsum == 0) lsum = 1;
            if(rsum == 0) rsum = 1;
        }
        return ret;
    }
};