#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <cstring>
using namespace std;

int n;
bool col[15];
/*
0,0  0,1  0,2  0,3  0,4
1,0  1,1  1,2  1,3  1,4
2,0  2,1  2,2  2,3  2,4
3,0  3,1  3,2  3,3  3,4
4,0  4,1  4,2  4,3  4,4
*/
// left dig i+j
bool ldiag[29]; 
// j-i+n
bool rdiag[29]; 

int abs(int a, int b){
    int ret = a-b;
    if(ret<0) return -1*ret;
    return ret;
}

int pick(int i){
    if(i>=n){
        return 1;
    }
    int ret = 0;
    // j: col
    for(int j=0; j<n; ++j){
        int ld = i+j;
        int rd = j-i+n;
        if(!col[j] && !ldiag[ld] && !rdiag[rd]){
            col[j] = true;
            ldiag[ld] = true;
            rdiag[rd] = true;
            ret += pick(i+1);
            col[j] = false;
            ldiag[ld] = false;
            rdiag[rd] = false;
        }
    }
    return ret;
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n;
    cout << pick(0);
    return 0;
}

