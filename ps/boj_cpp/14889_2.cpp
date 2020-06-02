#include <algorithm>
#include <iostream>
#include <vector>
using namespace std;

int total;
int arr[20][20];
int n, ans = 987654321;
vector<int> v;
vector<int> o;

void pick(int cur, int sum1, int sum2){
    
    if(cur>=n) {
        int tmp = sum1-sum2;
        if(tmp<0) tmp *= -1;
        ans = min(ans, tmp);
        return ;
    }
    int add = 0;
    int vlen = v.size();
    if(vlen<n/2){
        for(int i=0; i<vlen; ++i){
            add += arr[v[i]][cur]; 
            add += arr[cur][v[i]]; 
        }
        v.push_back(cur);
        pick(cur+1, sum1+add, sum2);
        v.pop_back();
    }
    
    
    add = 0;
    int olen = o.size();
    if(olen<n/2){
        for(int i=0; i<olen; ++i){
            add += arr[o[i]][cur]; 
            add += arr[cur][o[i]]; 
        }
        o.push_back(cur);
        pick(cur+1, sum1, sum2+add);
        o.pop_back();
    }
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n;
    
    for(int i=0; i<n; ++i){
        for(int j=0; j<n; ++j){
            cin >> arr[i][j];
            total += arr[i][j];
        } 
    }
    // v: 0을 넣은 팀, o: 나머지
    v.push_back(0);
    pick(1, 0, 0);
    cout << ans;
    return 0;
}