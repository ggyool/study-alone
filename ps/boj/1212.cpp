#include <iostream>
#include <string>
using namespace std;

string s;
const string arr[8] = {
    "000",
    "001",
    "010",
    "011",
    "100",
    "101",
    "110",
    "111"
};


int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cin >> s;
    int slen = s.size();
    int i=0;
    if(s[0] == '0') {
        cout << 0 ;
        return 0;
    }
    else if('1' <= s[0] && s[0] <='3'){
        if(s[0] == '1') cout << "1";
        if(s[0] == '2') cout << "10";
        if(s[0] == '3') cout << "11";
        i = 1;
    }
    for(; i<slen; ++i){
        cout << arr[s[i] - '0'];
    }
    return 0;
}