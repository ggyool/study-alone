#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <cstring>
using namespace std;

const int dx[4] = {1,-1,3,-3};
int dist[362880];
int sequence[362880];
int fact[10];
int sq[10];

int swapDigit(int n, int i, int j){
    int maxi = max(i,j);
    int mini = min(i,j);
    // min~max 사이
    int ret = n%sq[maxi];
    ret = (ret/sq[mini+1]*sq[mini+1]);
    // min 뒤
    ret += n%sq[mini];
    // max 앞
    ret += n/sq[maxi+1]*sq[maxi+1];
    // min max swap
    int minv = n/sq[mini]%10;
    int maxv = n/sq[maxi]%10;
    ret += (maxv*sq[mini] + minv*sq[maxi]);
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

bool inRange(int i){
    if(i<0 || i>8) return false;
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
        for(int i=0; i<4; ++i){
            int target = zero+dx[i];
            /*
            8 7 6
            5 4 3
            2 1 0
            */
            // 오른쪽이면 오른쪽으로 못가게
            // 왼쪽이면 왼쪽으로 못가게
            if(zero%3==0 && dx[i]==-1) continue;
            if((zero+1)%3==0 && dx[i]==1) continue;
            if(inRange(target)){
                int next = swapDigit(cur, zero, target);
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


