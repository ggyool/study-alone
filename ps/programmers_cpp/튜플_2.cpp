#include <string>
#include <vector>
#include <unordered_map>
#include <iostream>
#include <algorithm>
using namespace std;

vector<int> solution(string s) {
    unordered_map<int, int> mp;
    string tmp;
    int slen = s.size();
    for(int i=0; i<slen; ++i){
        if(s[i]>='0' && s[i] <= '9'){
            tmp += s[i];
        }
        else{
            if(!tmp.empty()){
                ++mp[stoi(tmp)];
                tmp.clear();
            }
        }
    }
    vector<pair<int,int>> pv;
    for(auto it=mp.begin(); it!=mp.end(); ++it){
        pv.push_back(make_pair(it->second, it->first));
    }
    sort(pv.begin(), pv.end());
    vector<int> ret;
    int plen = pv.size();
    for(int i=0; i<plen; ++i){
        ret.push_back(pv[plen-1-i].second);
    }
    return ret;    
}


int main(void){

    vector<int> v =  solution("{{2},{2,1},{2,1,3},{2,1,3,4}}");
    //vector<int> v =  solution("{{4,2,3},{3},{2,3,4,1},{2,3}}");
    for(int a : v) {
        cout << a << ' ';
    }

}