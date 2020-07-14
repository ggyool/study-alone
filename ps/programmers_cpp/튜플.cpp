#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
#include <stack>
#include <unordered_map>
using namespace std;
// 원소의 개수를 기준으로 정렬

vector<int> split(string &s){
    vector<int> ret;
    int slen = s.size();
    int bef = 0;
    for(int i=0; i<slen; ++i){
        if(s[i] == ','){
            ret.push_back(stoi(s.substr(bef, i-bef+1)));
            bef = i+1;
        }
    }
    ret.push_back(stoi(s.substr(bef, slen-bef)));
    return ret;
}

int diff(vector<int> &va, vector<int> &vb){
    int alen = va.size();
    int blen = vb.size();
    unordered_map<int, int> amp, bmp;
    for(int i=0; i<alen; ++i){
        ++amp[va[i]];
        ++bmp[vb[i]];
    }
    ++bmp[vb[blen-1]];
    for(auto it=bmp.begin(); it!=bmp.end(); ++it){
        if(it->second != amp[it->first]){
            return it->first;
        }
    }
    return -1;
}

vector<int> solution(string s) {
    
    int slen = s.size();
    int open = 1;
    vector<string> sv;
    for(int i=1; i<slen-1; ++i){
        if(s[i] == '}'){
            sv.push_back(s.substr(open+1, i-open-1));
        }
        else if(s[i] == '{'){
            open = i;
        }
    }
    // 배열크기, idx
    vector<pair<int, int>> pv;
    int svlen = sv.size();
    vector<vector<int>> v;
    for(int i=0; i<svlen; ++i){
        vector<int> tmp = split(sv[i]);
        pv.push_back(make_pair(tmp.size(), pv.size()));
        v.push_back(tmp);
    }
    sort(pv.begin(), pv.end());
    int pvlen = pv.size();
    vector<int> ret;
    
    ret.push_back(v[pv[0].second][0]);
    for(int i=1; i<pvlen; ++i){
        int idx = pv[i].second;
        int befIdx = pv[i-1].second;
        ret.push_back(diff(v[befIdx], v[idx]));
    }
    return ret;
}

int main(void){

    // vector<int> v =  solution("{{2},{2,1},{2,1,3},{2,1,3,4}}");
    vector<int> v =  solution("{{4,2,3},{3},{2,3,4,1},{2,3}}");
    for(int a : v) {
        cout << a << ' ';
    }

}