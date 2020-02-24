// 직접 그래프 만드는게 생각보다 짧을 것 같아서 만들었다.
// 임의로 노드 번호를 매겼다.
// 단점은 한번에 여러칸 못가고 next 타고 가는것
// 백트래킹 하였다. 최대 5칸 밖에 전진하지 않기 때문에 무난히 빠르다.
#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

struct Node{
    int val, next;
    Node(int _val = 0, int _next = 0){
        val = _val;
        next = _next;
    }
};

vector<int> v, horse, inp;
vector<Node> nv;
vector<bool> visited;
const int FIN = 32;
int maxScore;

int isAble(int step, int n){
    if(horse[n] == FIN) return -1;
    int cur, next;
    cur = horse[n];
    if(cur==5) next = 21;
    else if(cur==10) next = 25;
    else if(cur==15) next = 27;
    else next = nv[cur].next;
    cur = next;
    for(int i=1; i<step; ++i){
        next = nv[cur].next;
        cur = next;
    }
    return cur==FIN || !visited[cur] ? cur : -1;
}

void go(int cur, int next, int i){
    visited[cur] = false;
    visited[next] = true;
    horse[i] = next;
}

// 주사위 순서, 말의 번호, 점수
void pick(int idx, int score){
    if(idx==10){
        maxScore = max(maxScore, score);
        return;
    }
    for(int i=0; i<4; ++i){
        int next = isAble(inp[idx], i);
        if(next==-1) continue;
        int cur = horse[i];
        go(cur, next, i);
        pick(idx+1, score + nv[next].val);
        go(next, cur, i);
    }
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    nv = vector<Node>(33);
    // 맘대로 번호 붙여서 그래프 생성
    for(int i=0; i<=20; ++i){
        nv[i] = Node(2*i, i+1);
        if(i==20) nv[i].next = FIN;
    }
    nv[21] = Node(13, 22);
    nv[22] = Node(16, 23);
    nv[23] = Node(19, 24);
    nv[24] = Node(25, 30);
    nv[25] = Node(22, 26);
    nv[26] = Node(24, 24);
    nv[27] = Node(28, 28);
    nv[28] = Node(27, 29);
    nv[29] = Node(26, 24);
    nv[30] = Node(30, 31);
    nv[31] = Node(35, 20);
    nv[32] = Node(0, 32);

    visited = vector<bool>(33, false);
    horse = vector<int>(4, 0);
    inp = vector<int>(10);
    for(int i=0; i<10; ++i){
        cin >> inp[i];
    }
    pick(0, 0);
    cout << maxScore;
    return 0;
}