// 처음 풀 때 백트래킹 안하고 모든 조합 4**10 뽑았다.
#include <iostream>
#include <algorithm>
#include <cstring>
#include <vector>
using namespace std;

struct Pos{
    int y,x;
    Pos(int _y = 0, int _x = 0){
        y = _y, x = _x;
    }
};

int arr[5][21] = {
    {0,2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38,40},
    {10,13,16,19},
    {20,22,24},
    {30,28,27,26},
    {25,30,35,40}
};
int len[5] = {21,4,3,4,4};
bool chk[5][21];
vector<int> v, inp;
int maxScore = 0;

int range(int y, int x){
    return len[y] - x;
}

int solve(){
    memset(chk, false, sizeof(chk));
    vector<Pos> pv;
    vector<bool> isArrived(4, false);
    for(int i=0; i<4; ++i) pv.push_back(Pos(0,0));
    int idx, dice;
    int score = 0;
    for(int i=0; i<10; ++i){
        idx = v[i];
        dice = inp[i];
        if(isArrived[idx]) return -1;
        int cy = pv[idx].y;
        int cx = pv[idx].x;
        int nx = cx + dice;
        int ny = cy;
        if(ny>=1 && ny<=3){
            if(range(ny, nx) <= 0){
                ny = 4;
                nx = range(cy,nx) * -1;
            }
        }
        if(ny==0 && (nx==5 || nx==10 || nx==15 || nx==20)){
            ny = nx/5;
            nx = 0;
            if(ny==4) nx=3;
        }
        chk[cy][cx] = false;
        if((ny==0 || ny==4) && range(ny,nx) <= 0){
            isArrived[idx] = true;
            continue;
        }
        if(chk[ny][nx]) return -1;
        score += arr[ny][nx];
        chk[ny][nx] = true;
        pv[idx].x = nx;
        pv[idx].y = ny;
        
    }
    return score;
}


void pick(int idx, int n){
    
    if(idx >= 10) {
        maxScore = max(maxScore, solve());
        return;
    }
    if(n >=4 ) return;
    
    // 뽑은 경우
    v.push_back(n);
    pick(idx+1, 0);
    v.pop_back();

    // 안 뽑은 경우
    pick(idx, n+1);
}

int main(void){
    int n;
    for(int i=0; i<10; ++i){
        cin >> n;
        inp.push_back(n);
    }
    pick(0, 0);
    cout << maxScore;
    return 0;
}


