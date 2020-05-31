#include <iostream>
#include <stack>
#include <algorithm>
#include <vector>
#include <queue>
using namespace std;


class Solution {
public:
    priority_queue<int> pq;
    int lastStoneWeight(vector<int>& stones) {
        int len = stones.size();
        for(int i=0; i<len; ++i){
            pq.push(stones[i]);
        }
        while(pq.size()>1){
            int y = pq.top();
            pq.pop();
            int x = pq.top();
            pq.pop();
            if(y>x) pq.push(y-x);
        }
        if(pq.size()==1) return pq.top();
        else return 0;
    }
};

int main(void){
    Solution sol = Solution();
    vector<int> v= {2,2};
    cout << sol.lastStoneWeight(v);
    return 0;
}