#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
using namespace std;

struct Pos{
    int st, en;
    Pos(int _st, int _en):st(_st),en(_en){}
    bool operator<(const Pos &ref) const{
        if(st==ref.st) return en>ref.en;
        return st>ref.st;
    }
};

priority_queue<Pos> pq;

class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        vector<vector<int>> ret;
        int len = intervals.size();
        for(int i=0; i<len; ++i){
            pq.push(Pos(intervals[i][0], intervals[i][1]));
        }
        int bst = -1, ben;
        int cst, cen;
        while(!pq.empty()){
            if(bst==-1){
                bst= pq.top().st;
                ben = pq.top().en;
                pq.pop();
                continue;
            }
            cst = pq.top().st;
            cen = pq.top().en;
            pq.pop();
            if(cst<=ben){
                if(cen>ben) ben = cen;
            }
            else{
                ret.push_back({bst, ben});
                bst = cst;
                ben = cen;
            }
        }   
        if(bst!=-1){
            ret.push_back({bst, ben});
        }
        return ret;
    }
};

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    return 0;
}