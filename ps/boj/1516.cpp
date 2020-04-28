#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

int n;
vector<vector<int>> v;
vector<int> ind, takeTime, finTime;

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n;
    v = vector<vector<int>> (n+1);
    ind = vector<int>(n+1, 0);
    takeTime = vector<int>(n+1, 0);
    finTime = vector<int>(n+1, 0);
    int num;
    for(int i=1; i<=n; ++i){
        cin >> takeTime[i];
        while(true){
            cin >> num;
            if(num==-1) break;
            v[num].push_back(i);
            ind[i]++;
        }
    }
    queue<int> q;
    for(int i=1; i<=n; ++i){
        if(ind[i] == 0){
            q.push(i);
            finTime[i] = takeTime[i];
        }
            
    }

    while(!q.empty()){
        int cur = q.front();
        int curTime = finTime[cur];
        q.pop();
        int len = v[cur].size();
        for(int i=0; i<len; ++i){
            int next = v[cur][i];
            --ind[next];
            finTime[next] = max(finTime[next], curTime + takeTime[next]);
            if(ind[next] == 0){
                q.push(next);
            }
        }
    }
    
    for(int i=1; i<=n; ++i){
        cout << finTime[i] << '\n';     
    }

    return 0;
}
