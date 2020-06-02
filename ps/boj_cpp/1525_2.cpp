#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <cstring>
using namespace std;

const int dx[4] = {1,0,-1,0};
const int dy[4] = {0,1,0,-1};
int dist[362880];
int sequence[362880];
int fact[10];
int sq[10];

// 개선
int swapDigit(int n, int i, int j){
    int ret = n;
    int iv = n/sq[i]%10;
    int jv = n/sq[j]%10;
    ret -= iv*sq[i];
    ret += jv*sq[i];
    ret -= jv*sq[j];
    ret += iv*sq[j];
    return ret;
}

int findZero(int n){
    int i = 0;
    while(n){
        int r = n%10;
        if(r==0) break;
        n/=10;
        i++;
    }
    return i;
}

// 개선
bool inRange(int y, int x){
    if(y<0 || x<0 || y>2 || x>2) return false;
    return true;
}

// 0 ~ 9!-1
int getSequence(int num){
    int ret = 0;
    vector<bool> visited(9, false); // 0~8
    // 123456780
    for(int i=8; i>=0; --i){
        int curDigit = num/sq[i]%10;
        for(int j=0; j<curDigit; ++j){
            if(!visited[j])
                ret += fact[i];
        }
        visited[curDigit] = true;
    }
    return ret;
}

int bfs(int start){
    memset(dist, -1, sizeof(dist));
    int eidx = getSequence(123456780);
    queue<int> q;
    int sidx = getSequence(start);
    q.push(start);
    dist[sidx] = 0;
    while(!q.empty()){
        int cur = q.front();
        int cidx = getSequence(cur);
        if(cidx==eidx) return dist[cidx];
        q.pop();
        int zero = findZero(cur);
        int zy = zero/3;
        int zx = zero%3;
        for(int i=0; i<4; ++i){
            int ny = zy + dy[i];
            int nx = zx + dx[i];
            if(inRange(ny,nx)){
                int next = swapDigit(cur, zero, ny*3+nx);
                int nidx = getSequence(next);
                if(dist[nidx]==-1){
                    dist[nidx] = dist[cidx] + 1;
                    q.push(next);
                }
            }
        }
    }
    return -1;
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    fact[0] = 1;
    // 10**i
    sq[0] = 1;
    for(int i=1; i<=9; ++i){
        sq[i] = 10*sq[i-1];
        fact[i] = i*fact[i-1];
    }
    int start = 0;
    int num;
    for(int i=0; i<9; ++i){
        cin >> num;
        start = 10*start + num;
    }
    cout << bfs(start);
    return 0;
}
