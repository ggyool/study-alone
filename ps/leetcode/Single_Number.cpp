#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

class Solution {
public:
    int singleNumber(vector<int>& v) {
        /*sort(v.begin(), v.end());
        int len = v.size();
        int ans = 0;
        bool isFind = false;
        for(int i=1; i<len; i+=2){
            if(v[i] != v[i-1]){
                ans = v[i-1];
                isFind = true;
                break;
            }
        }
        if(!isFind) ans = v[len-1];
        return ans;*/
        int ans = 0;
        // 0 ^ n -> n
        // n^m -> ?
        // ?^m -> n
        for(int i=0; i<v.size(); ++i){
            ans ^= v[i];
        }
        return ans;
    }
};

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);


    return 0;
}