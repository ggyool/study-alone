#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int a,p;
int sq[10][6];
int arr[1000000];

int calcNext(int num){
    int ret = 0;
    while(num>0){
        int r = num %10;
        ret += sq[r][p];
        num /= 10;
    }
    return ret;
}

int dfs(int cur){
    int next = calcNext(cur);
    if(arr[next] == 0){
        arr[next] = arr[cur] + 1;
        return dfs(next);
    }
    else{
        return arr[next]-1;
    }
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> a >> p;
    for(int i=1; i<=9; ++i){
        sq[i][1] = i;
        for(int j=2; j<=5; ++j){
            sq[i][j] = sq[i][j-1] * i;
        }
    }
    arr[a] = 1;
    cout << dfs(a);
    return 0;
}
