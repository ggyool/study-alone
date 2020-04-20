#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <cstring>
#include <functional>
using namespace std;

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    vector<string> ev ,lv;
    int n;
    cin >> n;
    string name, cmd;
    // enter 가 있어야 leave 가 나올 수 있고, 
    // enter leave 짝으로 여러번 나올 수 있다.
    for(int i=0; i<n; ++i){
        cin >> name >> cmd;
        if(cmd[0] == 'e'){
            ev.push_back(name);
        }
        else{
            lv.push_back(name);
        }
    }
    sort(ev.begin(), ev.end(), greater<string>());
    sort(lv.begin(), lv.end(), greater<string>());
    int elen = ev.size();
    int llen = lv.size();
    int j = 0;
    for(int i=0; i<elen; ++i){
        if(j==llen){
            cout << ev[i] << '\n';
        }
        else if(ev[i] == lv[j]) ++j;
        else{
            cout << ev[i] << '\n';
        }
    }
    return 0;
}

