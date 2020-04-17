#include <iostream>
#include <algorithm>
#include <vector>
#include <stack>
#include <cstring>
#include <deque>
using namespace std;


string s, ls;
deque<char> dq;

bool check(){
    int slen = s.size();
    int dqlen = dq.size();
    if(dqlen<slen) return false;
    for(int i=0; i<slen; ++i){
        if(s[i]!=dq[dqlen-slen+i]) return false;
    }
    return true;
}

string solve(){
    int lslen = ls.size();
    int slen = s.size();
    int i = 0;
    while(i<lslen){
        dq.push_back(ls[i]);
        if(check()){
            for(int i=0; i<slen; ++i) dq.pop_back();
        }
        ++i;
    }
    string ret;
    while(!dq.empty()){
        ret.push_back(dq.front());
        dq.pop_front();
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
