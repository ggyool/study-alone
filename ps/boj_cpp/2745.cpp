#include <iostream>
#include <string>
using namespace std;

string s;
int b;

int main(void){
    cin >> s >> b;
    int slen = s.size();
    int ans = 0;
    for(int i=0; i<slen; ++i){
        if('A' <= s[i] && s[i] <= 'Z'){
            ans = ans*b + (s[i] - 'A' + 10);
        }else{
            ans = ans*b + (s[i] - '0');
        }
    }
    cout << ans;
    return 0;
}