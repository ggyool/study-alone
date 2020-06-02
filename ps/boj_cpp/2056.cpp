#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;


struct Task{
    int num, end;
    Task(int _num, int _end) : num(_num), end(_end){}
    bool operator<(const Task &ref) const{
        return end>ref.end;
    }
};

int n, m;
vector<vector<int>> v;
vector<int> ind, takeTime;

int topoSort(){
    priority_queue<Task> pq;
    int ret = 0;
    for(int i=1; i<=n; ++i){
        if(ind[i] == 0){
            // i Task 가 takeTime[i]에 끝난다.
            pq.push(Task(i, takeTime[i]));
        }
    }
    while(!pq.empty()){
        int num = pq.top().num;
        int end = pq.top().end;
        ret = max(ret, end);
        pq.pop();
        int len = v[num].size();
        for(int i=0; i<len; ++i){
            int next = v[num][i];
            --ind[next];
            if(ind[next] == 0){
                pq.push(Task(next, end+takeTime[next]));
            }
        }
    }
    return ret;
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n;
    v = vector<vector<int>>(n+1);
    ind = vector<int>(n+1, 0);
    takeTime = vector<int>(n+1, 0);
    for(int i=1; i<=n; ++i){
        cin >> takeTime[i] >> m;
        ind[i] = m;
        for(int j=0; j<m; ++j){
            int x;
            cin >> x;
            v[x].push_back(i);
        }
    }
    cout << topoSort();
    return 0;
}
