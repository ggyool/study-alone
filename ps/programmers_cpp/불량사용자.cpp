#include <string>
#include <vector>
#include <iostream>
#include <unordered_set>

using namespace std;

int ulen, blen;
vector<string> u,b;
vector<bool> visited;
unordered_set<vector<bool>> st;

bool isAble(string &sa, string &sb){
    int alen = sa.size();
    int blen = sb.size();
    if(alen!=blen) return false;
    for(int i=0; i<alen; ++i){
        if(sb[i]=='*') continue;
        if(sa[i] != sb[i]) return false;
    }
    return true;
}

int dfs(int bidx){
    if(bidx==blen){
        if(st.find(visited) == st.end()){
            st.insert(visited);
            return 1;
        }
        return 0;
    }
    int ret = 0;
    for(int i=0; i<ulen; ++i){
        if(!visited[i] && isAble(u[i], b[bidx])){
            visited[i] = true;
            ret += dfs(bidx+1);
            visited[i] = false;
        }
    }
    return ret;
}

int solution(vector<string> user_id, vector<string> banned_id) {
    u = user_id;
    b = banned_id;
    ulen = u.size();
    blen = b.size();
    visited = vector<bool> (ulen, false);
    return dfs(0);
}

int main(void){
    vector<string> v1 = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
    vector<string> v2 ={"fr*d*", "abc1**"};
    cout << solution(v1,v2);
    
    return 0;
}