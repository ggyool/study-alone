#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <cstring>
#include <unordered_map>
#include <map>
using namespace std;

// 7785.cpp 보다 빠를거라고 예상하고 해봤지만 느림
int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int n;
    map<string, int> emp;
    unordered_map<string, int> lmp;
    cin >> n;
    string name,cmd;
    for(int i=0; i<n; ++i){
        cin >> name >> cmd;
        if(cmd[0] == 'e'){
            auto it = emp.find(name);
            if(it==emp.end()) emp.insert({name,1});
            else ++(it->second);
        }
        else{
            auto it = lmp.find(name);
            if(it==lmp.end()) lmp.insert({name, 1});
            else ++(it->second);
        }
    }
    for(auto it=emp.rbegin(); it!=emp.rend(); ++it){
        auto lit = lmp.find(it->first);
        if(lit==lmp.end()) cout << it->first << '\n';
        else{
            if(it->second != lit->second){
                cout << it->first << '\n';   
            }
        }
    }
    return 0;
}

