#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
#include <string>
#include <cstring>
using namespace std;

const int INF = (int)1e6;
const int dy[4] = {0,1,0,-1};
const int dx[4] = {1,0,-1,0};
int arr[100][100];
int dist[100][100];
int r,c;

struct Node{
    int y, x, val;
    Node(int _y, int _x, int _val)
    : y(_y), x(_x), val(_val) {}
    bool operator<(const Node &ref) const{
        return val > ref.val;
    }
};

bool inRange(int y, int x){
    if(y<0 || x<0 || y>=r || x>=c) return false;
    return true;
}

int solve(){
    for(int i=0; i<r; ++i){
        for(int j=0; j<c; ++j){
            dist[i][j] = INF;
        }
    }
    priority_queue<Node> pq;
    dist[0][0] = 0;
    pq.push(Node(0,0,dist[0][0]));
    while(!pq.empty()){
        Node cur = pq.top();
        int cy = cur.y;
        int cx = cur.x;
        int cv = cur.val;
        pq.pop();
        if(cv>dist[cy][cx]) continue;
        for(int i=0; i<4; ++i){
            int ny = cy + dy[i];
            int nx = cx + dx[i];
            if(!inRange(ny,nx)) continue;
            int nv = cv + (arr[ny][nx] == 1);
            if(dist[ny][nx]>nv){
                dist[ny][nx] = nv;
                pq.push(Node(ny,nx,dist[ny][nx])); 
            }
        }
    }
    return dist[r-1][c-1];
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> c >> r;
    for(int i=0; i<r; ++i){
        string s;
        cin >> s;
        for(int j=0; j<c; ++j){
            arr[i][j] = s[j] - '0';
        }
    }
    cout << solve();
    return 0;
}
