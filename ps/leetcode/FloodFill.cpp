#include <iostream>
#include <vector>
#include <queue>
using namespace std;

class Solution {
public:
    int r,c;
    const int dy[4] = {0,1,0,-1};
    const int dx[4] = {1,0,-1,0};
    bool inRange(int y, int x){
        if(y<0 || x<0 || y>=r || x>=c) return false;
        return true;
    }
    void bfs(vector<vector<int>> &v, int sr, int sc, int startColor, int newColor){
        vector<vector<bool>> visited(r, vector<bool>(c, false));
        queue<pair<int, int>> q;
        q.push({sr, sc});
        visited[sr][sc] = true;
        v[sr][sc] = newColor;
        while(!q.empty()){
            int cy = q.front().first;
            int cx = q.front().second;
            q.pop();
            for(int i=0; i<4; ++i){
                int ny = cy + dy[i];
                int nx = cx + dx[i];
                if(inRange(ny,nx) && !visited[ny][nx] && v[ny][nx] == startColor){
                    visited[ny][nx] = true;
                    v[ny][nx] = newColor;
                    q.push({ny,nx});
                }
            }
        }
    }
    vector<vector<int>> floodFill(vector<vector<int>>& v, int sr, int sc, int newColor) {
        r = v.size();
        if(r==0) return {};
        c = v[0].size();
        bfs(v,sr,sc,v[sr][sc],newColor);
        return v;
    }
};