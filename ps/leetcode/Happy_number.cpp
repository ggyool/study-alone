#include <iostream>
#include <cstring>
#include <unordered_set>
using namespace std;

const int sq[10] = {0,1,4,9,16,25,36,49,64,81};

class Solution {
public:
    unordered_set<int> st;
    int findNext(int n){
        int ret = 0 ;
        while(n>0){
            ret += sq[n%10];
            n /= 10;
        }
        return ret;
    }
    bool isHappy(int n) {
        st.insert(n);
        while(true){
            int next = findNext(n);
            if(next==1) return true;
            if(st.count(next)>0) return false;
            else st.insert(next);
            n = next;
        }
        return false;
    }
};

int main(void){
    int n;
    cin >> n;
    Solution sol = Solution();
    cout << sol.isHappy(n);
    return 0;
}


