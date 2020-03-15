#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>
using namespace std;

const int dy[4] = {0,1,0,-1};
const int dx[4] = {1,0,-1,0};

struct Pos{
    int y,x;
    Pos(int _y, int _x)
        : y(_y), x(_x)
    {}
};

struct Edge{
    int to, cost;
    Edge(int a, int b)
        :to(a), cost(b)
    {}
    bool operator<(const Edge &ref) const{
        return cost > ref.cost;
    }
};

int oy,ox,oi;
int r,c;
// 방문해야 하는 노드
vector<Pos> pv;
int plen = 0;

char arr[20][20];

// i->j 가는 최단 경로
int nodeDist[10][10];
vector<bool> visited;


bool inRange(int y, int x){
    if(y<0 || x<0 || y>=r || x>=c) return false;
    return true;
}

void bfs(int f){
    int sy = pv[f].y;
    int sx = pv[f].x;
    queue<Pos> q;
    vector<vector<int>> dist = vector<vector<int>>(r, vector<int>(c, -1));
    dist[sy][sx] = 0;
    q.push(Pos(sy,sx));
    while(!q.empty()){
        int cy = q.front().y;
        int cx = q.front().x;
        q.pop();
        for(int i=0; i<4; ++i){
            int ny = cy + dy[i];
            int nx = cx + dx[i];
            if(!inRange(ny,nx) || dist[ny][nx]!=-1 || arr[ny][nx]=='x') continue;
            dist[ny][nx] = dist[cy][cx] + 1;
            q.push(Pos(ny,nx));
        }
    }
    for(int i=0; i<plen; ++i){
        if(i==f) continue;
        int ey = pv[i].y;
        int ex = pv[i].x;
        nodeDist[f][i] = dist[ey][ex];
    }
}

int solve(){
    priority_queue<Edge> pq;
    visited = vector<bool>(plen, false);
    visited[oi] = true;
    
    int ret = 0;
    int cnt = 1;
    while(true){
        int next = findVisitNode(cur);
        if(next == -1) break;
        ret += nodeDist[cur][next];
        ++cnt;
        visited[next] = true;
        cur = next;
    }
    return cnt==plen?ret:-1;
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    while(true){
        cin >> c >> r;
        plen = 0;
        pv.clear();
        if(c==0 && r==0) break;
        for(int i=0; i<r; ++i){
            for(int j=0; j<c; ++j){
                cin >> arr[i][j];
                if(arr[i][j]=='o' || arr[i][j]=='*'){
                    if(arr[i][j]=='o') oy=i, ox=j, oi=plen;
                    ++plen;
                    pv.push_back(Pos(i,j));
                }
            }
        }
        for(int i=0; i<plen; ++i){
            bfs(i);
        }
        cout << solve() << '\n';
    }
    /*
    cout <<"nodedist\n";
    priority_queue<Edge> pq;
    for(int i=0; i<plen; ++i)
    {
        pq.push(Edge(i, nodeDist[0][i]));
        
    }
    */
    return 0;
}