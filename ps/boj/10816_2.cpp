#include <iostream>
#include <algorithm>
#include <vector>
#include <unordered_map>
using namespace std;


// multiset,set, map, multimap 시간초과
// unordered_map 느림
// unordered_multiset 시간초과
// insert 과정에서 오래걸리는 것이라 추측
int n,m;
unordered_map<int, int> mp;


int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n;
    int num;
    for(int i=0; i<n; ++i){
        cin >> num;
        if(mp.count(num)==0){
            mp.insert({num, 1});
        }else{
            ++mp[num];
        }   
    }
    cin >> m;
    for(int i=0; i<m; ++i){
        cin >> num;
        auto it = mp.find(num);
        if(it==mp.end()) cout << 0 << ' ';
        else cout << it->second << ' ';
    }
    return 0;
}