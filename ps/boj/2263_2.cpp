#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int n;
vector<int> inOrder; // 1 2 3
vector<int> postOrder; //1 3 2
vector<int> pos;



void separate(int inL, int inR, int poL, int poR){
    if(inL>inR) return;   
    // post order 마지막은 root 노드 - 핵심
    int sep = pos[postOrder[poR]];
    int len = sep-inL;
    // vector 안만들고 여기서 출력 1460->36
    cout << postOrder[poR] << ' ';
    separate(inL, sep-1, poL, poL+len-1);
    separate(sep+1, inR, poL+len, poR-1);
}

int main(void){
    ios_base::sync_with_stdio(false);   
    cin.tie(0);
    cout.tie(0);
    cin >> n;
    inOrder = vector<int>(n);
    postOrder = vector<int>(n);
    pos = vector<int>(n+1);
    for(int i=0; i<n; ++i) {
        cin >> inOrder[i];
         // 미리 노드의 위치를 계산해 놓는다.
         // 2600->1460
        pos[inOrder[i]] = i;
    }
    for(int i=0; i<n; ++i) {
        cin >> postOrder[i];
    }
    separate(0, n-1, 0, n-1);
    return 0;
}
