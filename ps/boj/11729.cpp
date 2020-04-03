#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
using namespace std;

int n;
vector<pair<int, int>> v;

void move(int from, int to, int floor){
    if(floor==1){
        v.push_back({from, to});
        return;    
    }
    move(from, 6-from-to, floor-1);
    v.push_back({from, to});
    move(6-from-to, to, floor-1);
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n;
    move(1, 3, n);
    // d[i-1] + 1 + d[i-1]
    cout << v.size() << '\n';
    int len = v.size();
    for(int i=0; i<len; ++i){
        cout << v[i].first << ' ' << v[i].second << '\n';
    }
    return 0;
}

