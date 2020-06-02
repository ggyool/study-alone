#include <iostream>
#include <algorithm>
#include <string>
using namespace std;

// 1년전 처음 풀었던 코드를 보고 따옴
// 그때는 뒤에서 풀 생각을 했다니
string s;

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> s;
    int slen = s.size();
    int bracket = 0;
    int d = 1;
    int ans = 0;
    for(int i=0; i<slen; ++i){
        char c = s[slen-1-i];
        if(c=='+'){
            d=1;
        }
        else if(c=='-'){
            ans -= bracket;
            d = 1;
            bracket = 0;
        }
        else{
            bracket += d*(c - '0');
            d *= 10;
        }
    }
    ans += bracket;
    cout << ans;
    return 0;
}
