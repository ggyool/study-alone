#include <iostream>
#include <algorithm>
#include <vector>
#include <stack>
#include <deque>
#include <cstring>
#include <string>
using namespace std;

string s,t;
int slen, tlen;
int lt, rt;
deque<char> ldeq;
deque<char> rdeq;

/*
aab
aaaaab
*/

bool chkLeft(){
    int len = ldeq.size();
    if(len<slen) return false;
    for(int i=0; i<slen; ++i){
        if(s[i] != ldeq[len-slen+i])
            return false;
    }
    return true;
}

bool findLeft(){
    while(lt<=rt || !rdeq.empty()){
        char c;
        if(lt<=rt) c = t[lt];
        else {
            c = rdeq.front();
            rdeq.pop_front();
        }
        ldeq.push_back(c);
        if(lt<=rt) ++lt;
        if(chkLeft()){
            for(int i=0; i<slen; ++i) ldeq.pop_back();
            return true;
        }
    }
    return false;
}

bool chkRight(){
    int len = rdeq.size();
    if(len<slen) return false;
    for(int i=0; i<slen; ++i){
        if(s[i] != rdeq[i])
            return false;
    }
    return true;
}

bool findRight(){
    while(lt<=rt || !ldeq.empty()){
        char c;
        if(lt<=rt) c = t[rt];
        else {
            c = ldeq.back();
            ldeq.pop_back();
        }
        rdeq.push_front(c);
        if(lt<=rt) --rt;
        if(chkRight()){
            for(int i=0; i<slen; ++i) rdeq.pop_front();
            return true;
        }
    }
    return false;
}

string buildString(){
    string ret;
    while(!ldeq.empty()){
        ret.push_back(ldeq.front());
        ldeq.pop_front();
    }
    while(!rdeq.empty()){
        ret.push_back(rdeq.front());
        rdeq.pop_front();
    }
    return ret;
}

string solve(){
    tlen = t.size();
    slen = s.size();
    lt = 0;
    rt = tlen-1;
    while(true){
        if(!findLeft()) break;
        if(!findRight()) break;
    }
    return buildString();
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> s >> t;
    cout << solve();
    return 0;
}

