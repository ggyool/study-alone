#include <iostream>
#include <algorithm>
using namespace std;

char lnode[26];
char rnode[26];
int n;

void preOrder(char cur){
    cout << cur;
    if(lnode[cur-'A'] != '.') preOrder(lnode[cur-'A']);
    if(rnode[cur-'A'] != '.') preOrder(rnode[cur-'A']);
}

void inOrder(char cur){
    if(lnode[cur-'A'] != '.') inOrder(lnode[cur-'A']);
    cout << cur;
    if(rnode[cur-'A'] != '.') inOrder(rnode[cur-'A']);
}

void postOrder(char cur){
    if(lnode[cur-'A'] != '.') postOrder(lnode[cur-'A']);
    if(rnode[cur-'A'] != '.') postOrder(rnode[cur-'A']);
    cout << cur;
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n;
    for(int i=0; i<n; ++i){
        char a,b,c;
        cin >> a >> b >>c;
        lnode[a-'A'] = b;
        rnode[a-'A'] = c;
    }
    preOrder('A'); cout << '\n';
    inOrder('A'); cout << '\n';
    postOrder('A'); cout << '\n';
    return 0;
}
