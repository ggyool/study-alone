#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
#include <map>
using namespace std;


int solution(vector<int> v, int k) {
    int n = v.size();
    map<int, int> mp;
    for(int i=0; i<k; ++i){
        ++mp[v[i]];
    }
    int ret = mp.rbegin()->first;
    
    for(int i=k; i<n; ++i){
        ++mp[v[i]];
        --mp[v[i-k]];
        
        if(mp[v[i-k]] == 0) {
            mp.erase(v[i-k]);
        }
        ret = min(ret, mp.rbegin()->first);
    }
    return ret;
}

int main(void){

    vector<int> v = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
    cout << solution(v,3);
    return 0;
}