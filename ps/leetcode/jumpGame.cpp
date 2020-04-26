#include <algorithm>
#include <vector>
#include <iostream>
#include <unordered_map>
#include <queue>
using namespace std;

class Solution {
public:
    bool canJump(vector<int>& v) {
        int n = v.size();
        vector<bool> visited(n, false);
        visited[0] = true;
        queue<int> q;
        q.push(0);
        int maxIdx = 0;
        while(!q.empty()){
            int cur = q.front();
            q.pop();
            for(int i=v[cur]; i>=1; --i){
                if(cur+i<=maxIdx) break;
                if(cur+i<n && !visited[cur+i]){
                    visited[cur+i] = true;
                    q.push(cur+i);
                }
            }
            maxIdx = cur+v[cur];
        }
        return visited[n-1];
    }
};