#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int n,m,k;
vector<int> v;

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n >> m >> k;
    // k개 사용해서 감소 수열 하나 만들고 나머지로 증가 수열 만들 수 있는지
    if(n-k<m-1 || n>m*k){
        cout << -1;
        return 0;
    }
    for(int i=k; i>=1; --i) v.push_back(i);
    if(n-k>0){
        int p = (n-k)/(m-1);
        int r = (n-k)%(m-1);
        int i=k+1;
        while(i<=n){
            int jump = p;
            if(r>0) {
                jump = p+1;
                --r;
            }
            int end = min(n, i+jump-1);
            for(int j=end; j>=i; --j){
                v.push_back(j);
            }
            i = end+1;
        }
    }
    for(int i=0; i<n; ++i){
        cout << v[i] << ' ';
    }
    return 0;
}

