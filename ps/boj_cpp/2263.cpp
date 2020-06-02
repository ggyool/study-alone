#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int n;
vector<int> inOrder; // 1 2 3
vector<int> postOrder; //1 3 2
vector<bool> check;

int findSep(int left, int right, int rootVal){
    for(int i=left; i<=right; ++i){
        if(inOrder[i] == rootVal) return i;
    }
    return left;
}


vector<int> separate(int inL, int inR, int poL, int poR){
    if(inL>inR) return {};   
    if(inL==inR) return {inOrder[inL]};
    // post order 마지막은 root 노드 - 핵심
    vector<int> preOrder = {postOrder[poR]};
    int sep = findSep(inL, inR, postOrder[poR]);
    int len = sep-inL;
    vector<int> v = separate(inL, sep-1, poL, poL+len-1);
    preOrder.insert(preOrder.end(), v.begin(), v.end());
    v = separate(sep+1, inR, poL+len, poR-1);
    preOrder.insert(preOrder.end(), v.begin(), v.end());
    return preOrder;
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n;
    inOrder = vector<int>(n);
    postOrder = vector<int>(n);
    check = vector<bool>(n+1);
    for(int i=0; i<n; ++i) cin >> inOrder[i];
    for(int i=0; i<n; ++i) cin >> postOrder[i];
    vector<int> v = separate(0, n-1, 0, n-1);
    for(int i=0; i<n; ++i){
        cout << v[i] << ' ';
    }
    return 0;
}
