#include <deque>
#include <vector>
#include <string>
#include <algorithm>
using namespace std;


class Solution {
public: 
    const int dy[4] = {0,1,0,-1};
    const int dx[4] = {1,0,-1,0};
    int r,c;
    vector<vector<bool>> visited;
    bool inRange(int y, int x){
        if(y<0 || x<0 || y>=r || x>=c) return false;
        return true;
    }
    int numIslands(vector<vector<char>>& grid) {
        r = grid.size();
        if(r!=0) c = grid[0].size();
        if(r==0) return 0;  
        visited = vector<vector<bool>>(r, vector<bool>(c,false)) ;
        return dfsAll(grid);
    }
    void dfs(int y, int x, vector<vector<char>>& grid){
        int ny,nx;
        for(int i=0; i<4; ++i){
            ny = y + dy[i];
            nx = x + dx[i];
            if(inRange(ny,nx) && !visited[ny][nx] && grid[ny][nx]=='1'){
                visited[ny][nx] = true;
                dfs(ny,nx, grid);
            }
        }
    }    
    int dfsAll(vector<vector<char>>& grid){
        int ret = 0;
        for(int i=0; i<r; ++i){
            for(int j=0; j<c; ++j){
                if(!visited[i][j] && grid[i][j]=='1'){
                    ++ret;
                    visited[i][j] = true;
                    dfs(i,j, grid);
                }
            }
        }
        return ret;
    }
};