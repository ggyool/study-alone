#include <iostream>
#include <queue>
using namespace std;

struct Pos{
    int y,x,v;
    Pos(int _y, int _x, int _v) 
    : y(_y), x(_x), v(_v) {}
    bool operator<(const Pos ref) const{
        return v<ref.v;
    }
};

int n;
int  arr[1500][1500];
priority_queue<Pos> pq;

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n;
    for(int i=0; i<n; ++i){
        for(int j=0; j<n; ++j){
            cin >> arr[i][j];
        }
    }
    for(int i=0; i<n; ++i){
        pq.push(Pos(n-1, i, arr[n-1][i]));
    }
    for(int i=0; i<n-1; ++i){
        int cy = pq.top().y;
        int cx = pq.top().x;
        // 생각해보면, pq에 같은 수가 있어도 상관없다.
        pq.pop();
        if(cy==0) continue;
        pq.push(Pos(cy-1, cx, arr[cy-1][cx]));
    }
    
    cout << pq.top().v;
    return 0;
}