#include <algorithm>
#include <iostream>
#include <vector>
using namespace std;

int arr[20][20];
int n, ans = 987654321;
vector<int> v;

void printArr(vector<int> pv){
    for(int i=0; i<n/2; ++i){
        cout << pv[i] << ' ' ;
    }
    cout << '\n';
}

int calc(){
    vector<int> others;
    int j=0;
    for(int i=0; i<n; ++i){
        if(i==v[j]) ++j;
        else{
            others.push_back(i);
        }
    }
    int sum1=0, sum2=0;
    for(int i=0; i<n/2;++i){
        for(int j=0; j<n/2; ++j){
            sum1 += arr[v[i]][v[j]];
            sum2 += arr[others[i]][others[j]];
        }
    }
    int ret = sum1-sum2;
    if(ret<0) ret *= -1;
    return ret;
}

void pick(int cur, int pickn){
    if(pickn==n/2){ 
        ans = min(ans, calc());
        return;
    }
    // 0번째를 뽑은 경우와 안 뽑은 경우로 나누면 된다.
    if(cur>0 && pickn==0) return;
    if(cur>=n) return;

    v.push_back(cur);
    pick(cur+1, pickn+1);
    v.pop_back();
    
    pick(cur+1, pickn);
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n;
    
    for(int i=0; i<n; ++i){
        for(int j=0; j<n; ++j){
            cin >> arr[i][j];
        } 
    }
    pick(0, 0);
    cout << ans;
    return 0;
}