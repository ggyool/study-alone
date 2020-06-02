#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

struct Edge{
    int to,cost;
    Edge(int _to, int _cost) : to(_to), cost(_cost) {}
};

const int INF = (int)1e9;
vector<vector<Edge>> v;
int n,m;
int maxDepth = 1;
vector<int> depth, p;
// 부모 노드와의거리
vector<int> pcost;

// i번 노드의 2**j번 부모
vector<vector<int>> pp;
// i번 노드의 2**j 까지 가장 짧은 간선
vector<vector<int>> minv;
vector<vector<int>> maxv;

void calcDepth(int cur){
    int len = v[cur].size();
    for(int i=0; i<len; ++i){
        int next = v[cur][i].to;
        int cost = v[cur][i].cost;
        if(depth[next] == 0){
            depth[next] = depth[cur] + 1;
            maxDepth = max(maxDepth, depth[next]);
            p[next] = cur;
            pcost[next] = cost;
            calcDepth(next);
        }
    }
}

void solve(int a, int b){
    int minAns = INF;
    int maxAns = -1;
    if(depth[a]<depth[b]) 
        swap(a,b);
    int maxi;
    for(maxi=1; (1<<maxi)<=depth[a]; ++maxi);
    --maxi;

    // 높이를 맞춘다.
    for(int i=maxi; i>=0; --i){
        if(depth[a]-(1<<i) >=depth[b]){
            minAns = min(minAns, minv[a][i]);
            maxAns = max(maxAns, maxv[a][i]);
            a = pp[a][i];
        }
    }
    if(a==b){
        cout << minAns << ' ' << maxAns << '\n';
        return;
    }

    for(int i=maxi; i>=0; --i){
        if(pp[a][i] != pp[b][i]){
            minAns = min(minAns, minv[a][i]);
            minAns = min(minAns, minv[b][i]);
            maxAns = max(maxAns, maxv[a][i]); 
            maxAns = max(maxAns, maxv[b][i]); 
            a = pp[a][i];
            b = pp[b][i];
        }
    }
    minAns = min(minAns, minv[a][0]);
    minAns = min(minAns, minv[b][0]);
    maxAns = max(maxAns, maxv[a][0]); 
    maxAns = max(maxAns, maxv[b][0]);
    cout << minAns << ' ' << maxAns << '\n';
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n;
    v = vector<vector<Edge>> (n+1);
    depth = vector<int>(n+1);
    p =  vector<int> (n+1);
    pcost =  vector<int> (n+1);
    // 2**17 = 131072
    pp = vector<vector<int>> (n+1, vector<int>(18, 0));
    minv = vector<vector<int>> (n+1, vector<int>(18, INF));
    maxv = vector<vector<int>> (n+1, vector<int>(18, -INF));
    for(int i=0; i<n-1; ++i){
        int a,b,c;
        cin >> a >> b >> c;
        v[a].push_back(Edge(b,c));
        v[b].push_back(Edge(a,c));
    }
    depth[1] = 1;
    p[1] = 0;
    calcDepth(1);

    for(int i=1; i<=n; ++i){
        pp[i][0] = p[i];
        minv[i][0] = maxv[i][0] = pcost[i];
    }
    for(int j=1; (1<<j)<maxDepth; ++j){
        for(int i=1; i<=n; ++i){
            pp[i][j] = pp[pp[i][j-1]][j-1];
            minv[i][j] = min(minv[i][j-1], minv[pp[i][j-1]][j-1]);
            maxv[i][j] = max(maxv[i][j-1], maxv[pp[i][j-1]][j-1]);
        }
    }
    cin >> m;
    for(int i=0; i<m; ++i){
        int a,b;
        cin >> a >> b;
        solve(a,b);
    }
    return 0;
}
