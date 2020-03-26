#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

string s, ans;

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0); 
    cout.tie(0);
    cin >> s;
    int slen = s.size();
    if(slen==1 && s[0]=='0') {
        cout << 0;
        return 0;
    }
    int tmp = 0;
    for(int i=0; i<slen; ++i){
        int num = s[slen-1-i] - '0';
        if((i+1)%3 == 1){
            tmp += num;
        }
        else if((i+1)%3 == 2){
            tmp += 2*num;
        }
        else if((i+1)%3 == 0){
            tmp += 4*num;
            ans.push_back(tmp + '0');
            tmp = 0;
        }
    }
    if(tmp!=0) ans.push_back(tmp + '0');
    reverse(ans.begin(), ans.end());
    cout << ans;
    return 0;
}