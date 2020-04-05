#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int n;
vector<pair<int,int>> v;

int lis(){
    vector<pair<int, int>> tv;
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n;
    for(int i=0; i<n; ++i){
        int a,b;
        cin >> a >> b;
        v.push_back({a,b});
    }
    sort(v.begin(), v.end());
    
    return 0;
}
