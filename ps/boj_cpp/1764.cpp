#include <iostream>
#include <algorithm>
#include <vector>
#include <unordered_set>
#include <cstring>
#include <string>
using namespace std;

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    vector<string> va,vb;
    int n,m;
    string name;
    cin >> n >> m;
    while(n--){
        cin >> name;
        va.push_back(name);
    }   
    while(m--){
        cin >> name;
        vb.push_back(name);
    }
    sort(va.begin(), va.end());
    sort(vb.begin(), vb.end());
    int i = 0, j = 0;
    int alen = va.size();
    int blen = vb.size();
    vector<string> v;
    while(i<alen && j<blen){
        if(va[i]==vb[j]){
            v.push_back(va[i]);
            ++i, ++j;
        }
        else if(va[i] < vb[j]){
            ++i;
        }
        else{
            ++j;
        }
    }
    int len = v.size();
    cout << len << '\n';
    for(int i=0; i<len; ++i){
        cout << v[i] << '\n';
    }
    return 0;
}

