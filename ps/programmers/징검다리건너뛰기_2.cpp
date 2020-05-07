#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
#include <map>
using namespace std;

bool isAble(vector<int> &v, int mid, int k){
    int len = v.size();
    int cnt = 0;
    for(int i=0; i<len; ++i){
        if(v[i] <= mid){
            ++cnt;
            if(cnt==k) return true;
        }
        else{
            cnt = 0;
        }
    }
    return false;
}

// 기술블로그는 이분탐색이길래 풀어봄
int solution(vector<int> v, int k) {
    int n = v.size();
    
    int left=0, mid;
    int right  = v[0];
    for(int i=0; i<n; ++i){
        right = max(right, v[i]);
    }
    int ret = right;
    while(left<=right){
        mid = left + (right-left)/2;
        if(isAble(v, mid, k)){
            ret = min(ret, mid);
            right = mid - 1;
        }
        else{
            left = mid + 1;
        }
    }
    return ret;
}


int main(void){
    vector<int> v = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
    cout << solution(v,3);
    return 0;
}