#include <iostream>
#include <algorithm>
#include <string>
using namespace std;

string s;

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> s;
    char cur = '+';
    int slen = s.size();
    string tmp = "";
    int ans = 0;
    int bracket = 0;
    for(int i=0; i<slen; ++i){
        if(s[i]=='-'){
            int num = stoi(tmp);
            bracket += num;
            tmp.clear();
            if(cur=='+') ans += bracket;
            else ans -= bracket;
            cur = '-';
            bracket = 0;
        }
        else if(s[i]=='+'){
            int num = stoi(tmp);
            bracket += num;
            tmp.clear();
        }
        else{
            tmp += s[i];
        }
    }
    int num = stoi(tmp);
    bracket += num;
    if(cur=='+') ans += bracket;
    else ans -= bracket;
    cout << ans;
    return 0;
}
