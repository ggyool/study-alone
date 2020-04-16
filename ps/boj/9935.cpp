#include <iostream>
#include <algorithm>
#include <vector>
#include <stack>
#include <cstring>
#include <deque>
using namespace std;


string s, ls;
stack<pair<char, int>> stk;

string solve(){
    int lslen = ls.size();
    int slen = s.size();
    int i = 0;
    while(i<lslen){
        int findIdx;
        if(stk.empty()){
            findIdx = 0;
        }
        else{
            findIdx = stk.top().second+1;
        }
        if(s[findIdx] == ls[i]){
            stk.push({ls[i], findIdx});
            if(findIdx==slen-1){
                for(int j=0; j<slen; ++j) stk.pop();
            }
        }
        else{
            stk.push({ls[i], -1});
        }
        ++i;
    }
    string ret;
    while(!stk.empty()){
        ret.push_back(stk.top().first);
        stk.pop();
    }
    if(ret=="") return "FRULA";
    return ret;
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> ls >> s;
    cout << solve();
    return 0;
}
