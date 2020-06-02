#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int n,m;
vector<int> va, vb;

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n >> m;
    int num;
    for(int i=0; i<n; ++i) {
        cin >> num;
        va.push_back(num);
    }
    for(int i=0; i<m; ++i) {
        cin >> num;
        vb.push_back(num);
    }
    vector<int> v;
    int i=0, j=0;
    while(i<n && j<m){
        if(va[i] <= vb[j]) v.push_back(va[i++]);
        else v.push_back(vb[j++]);
    } 
    while(i<n)
        v.push_back(va[i++]);
    while(j<m)
        v.push_back(vb[j++]);
    for(int i=0; i<n+m; ++i){
        cout << v[i] << ' ';
    }
    return 0;
}
