#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
using namespace std;

int cnt[10];

// 모든 숫자를 사용해야한다.
string s;
int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> s;
    int len = s.size();
    int sum = 0;
    for(int i=0; i<len; ++i){
        ++cnt[s[i]-'0'];
        sum += s[i] - '0';     
    }
    
    if(cnt[0]>0 && sum%3==0){
        for(int i=9; i>=0; --i){
            for(int j=0; j<cnt[i]; ++j){
                cout << i;  
            }
        }
    }
    else cout << -1;
    return 0;
}
