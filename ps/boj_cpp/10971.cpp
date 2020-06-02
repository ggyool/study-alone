#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int n;
int arr[11][11];
bool visited[11];
const int BIG = 987654321;

int pick(int start, int from, int pickn){
    if(pickn==n){
        if(arr[from][start]==0) return BIG;
        return arr[from][start];
    }
    int ret = BIG;
    for(int i=1; i<=n; ++i){
        if(!visited[i] && (arr[from][i]>0 || start==-1)){
            visited[i] = true;
            if(start==-1) ret = min(ret, arr[from][i] + pick(i, i, pickn+1));
            else ret = min(ret, arr[from][i] + pick(start, i, pickn+1));
            visited[i] = false;
        }
    }
    return ret;
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n;
    for(int i=1; i<=n; ++i){
        for(int j=1; j<=n; ++j){
            cin >> arr[i][j];
        }
    }
    cout << pick(-1, 0, 0);
    return 0;
}
