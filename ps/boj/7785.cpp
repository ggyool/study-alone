#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <cstring>
#include <unordered_map>
using namespace std;

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int n;
    unordered_map<string, int> mp;
    cin >> n;
    string name,cmd;
    for(int i=0; i<n; ++i){
        cin >> name >> cmd;
        if(cmd[0] == 'e'){
            ++mp[name];
        }
        else{
            --mp[name];
        }
    }
    vector<string> v;
    for(auto it = mp.begin(); it!=mp.end(); ++it){
        if(it->second==1){
            v.push_back(it->first);
        }
    }
    sort(v.begin(), v.end());
    int len = v.size();
    for(int i=0; i<len; ++i){
        cout << v[len-1-i] << '\n';
    }
    return 0;
}

