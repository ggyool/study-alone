#include <iostream>
#include <algorithm>
#include <vector>
#include <map>
using namespace std;

map<int, int> mp;

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    mp.insert(make_pair(10,100));
    mp.insert({10,200});
    
    
    
    for(auto iter = mp.begin(); iter!=mp.end(); ++iter){
        cout << iter->first << ' ';
        cout << iter->second << '\n';    
    }
    return 0;
}
