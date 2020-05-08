#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

// time exceed
// 양방향 입력 받는데, depth 기억해서 올라가는 방향으로 탐색해야할듯?
// 균형잡혀있는 형태면 그냥 찾아도 mlogn 인것같은데?
// 한쪽 편향되어있는 경우 때문에 갈라지는 지점 기억해야할듯?


int n,m;
vector<vector<int>> v;
vector<int> depth;
// 자식이 2명 이상인지
vector<bool> splitNode;
// 가장 가까운 splitNode
// 자신이 splitNode이면 그 위 부모
vector<int> p;


void calcDepth(int cur){
    int len = v[cur].size();
    int curDepth = depth[cur];
    for(int i=0; i<len; ++i){
        int next = v[cur][i];
        if(depth[next] == 0){
            depth[next] = curDepth + 1;
            calcDepth(next);
        }
    }
}

void calcSplit(){
    splitNode[1] = 1;
    for(int i=2; i<=n; ++i){
        if(v[i].size()>=2){
            splitNode[i] = true;
        }
    }
}

int find(int cur){
    if(p[cur] != 0) return p[cur];
    int len = v[cur].size();
    for(int i=0; i<len; ++i){
        int next = v[cur][i];
        if(depth[next]>=depth[cur]) continue;
        if(splitNode[next]){
            return p[cur] = next;
        }
        else{
            return p[cur] = find(next);
        }
    }
    return -1;
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n;
    v = vector<vector<int>> (n+1);
    depth = vector<int>(n+1, 0);
    p = vector<int>(n+1, 0);
    splitNode = vector<bool>(n+1, false);
    depth[1] = 1;
    p[1] = 1;
    for(int i=0; i<n-1; ++i){
        int a,b;
        cin >> a >> b; 
        v[a].push_back(b);
        v[b].push_back(a);
    }
    calcDepth(1);
    calcSplit();
    cin >> m;
    for(int i=0; i<m; ++i){
        int a,b;
        cin >> a >> b;
        while(true){
            if(a==b) {
                cout << a << '\n';
                break;
            }
            if(depth[a] >= depth[b]){
                a = find(a);
            }
            else{
                b = find(b);
            }
        }
    }
    return 0;   
}
