#include <iostream>
#include <algorithm>
#include <vector>
#include <unordered_map>
#include <string>
using namespace std;

unordered_map<string, vector<string>> mp;
unordered_map<string, bool> visited;
vector<string> ans;
int n;

pair<string,string> split(string s){
    pair<string,string> ret;
    int slen = s.size();
    for(int i=0; i<slen; ++i){
        if(s[i]==' ') {
            ret.first = s.substr(0, i);
            ret.second = s.substr(i+4);
            break;
        }
    }
    return ret;
}

void dfs(string cur){
    int len = mp[cur].size();
    for(int i=0; i<len; ++i){
        string next = mp[cur][i];
        if(visited[next]==false){
            visited[next] = true;
            ans.push_back(next);
            dfs(next);
        }
    }
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n;
    cin.ignore();
    string s;
    for(int i=0; i<n; ++i){
        getline(cin, s);
        pair<string,string> res = split(s);
        string key = res.first;
        string val = res.second;
        mp[key].push_back(val);
    }    
    dfs("Baba");    
    sort(ans.begin(), ans.end());
    int len = ans.size();
    for(int i=0; i<len; ++i){
        cout << ans[i] << '\n';
    }
    return 0;
}