#include <iostream>
#include <vector>
#include <algorithm>
#include <thread>
#include <chrono>
using namespace std;

const int INF = (int)1e8;
int n,m;
int dp[101][101];
int via[101][101];

void findPath(int s, int e, vector<int>& path){
    if(via[s][e] == s){
        path.push_back(s);
        return;
    }
    findPath(s, via[s][e], path);
    findPath(via[s][e], e, path);
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    cin >> n >> m;
    for(int i=1; i<=n; ++i){
        for(int j=1; j<=n; ++j){
            if(i!=j) dp[i][j] = INF;
        }
    }

    for(int i=0; i<m; ++i){
        int a,b,c;
        cin >> a >> b >> c;
        dp[a][b] = min(dp[a][b], c);
        via[a][b] = a;
    }

    for(int k=1; k<=n; ++k){
        for(int i=1; i<=n; ++i){
            for(int j=1; j<=n; ++j){
                if(dp[i][j] > dp[i][k] + dp[k][j]){
                    dp[i][j] = dp[i][k] + dp[k][j];
                    via[i][j] = k;
                }
            }
        }
    }
    for(int i=1; i<=n; ++i){
        for(int j=1; j<=n; ++j){
            if(dp[i][j]==INF) cout << 0 << ' ';
            else cout << dp[i][j] << ' ';
        }   
        cout << '\n';
    }
    for(int i=1; i<=n; ++i){
        for(int j=1; j<=n; ++j){
            if(i==j || dp[i][j]==INF) cout << 0 << '\n';
            else {
                vector<int> path;
                findPath(i, j, path);
                path.push_back(j);
                cout << path.size() << ' ';
                for(int k=0; k<path.size(); ++k){
                    cout << path[k] << ' ';
                }
                cout << '\n';
            }
        }
    }
    return 0;
}
