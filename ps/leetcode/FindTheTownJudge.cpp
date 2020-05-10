#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

class Solution {
public:
    int findJudge(int N, vector<vector<int>>& v) {
        vector<int> cnt(N+1);
        vector<bool> believe(N+1);
        int vlen = v.size();
        for(int i=0; i<vlen; ++i){
            believe[v[i][0]] = true;
            ++cnt[v[i][1]];
        } 
        for(int i=1; i<=N; ++i){
            if(cnt[i] == N-1 && !believe[i]) return i;
        }
        return -1;
    }
};