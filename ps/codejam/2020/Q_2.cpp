#include <iostream>
#include <string>
#include <cstring>
using namespace std;

int tc, n;
string s;

void solve(){
    int slen = s.size();
    int open = 0;
    for(int i=0; i<slen; ++i){
        int num = s[i] - '0';
        if(num-open>0){
            for(int j=0; j<num-open; ++j){
                cout << '(';    
            }
            open += (num-open);
        }
        else if(num-open<0){
            for(int j=0; j<open-num; ++j){
                cout << ')';
            }
            open -= (open-num);
        }   
        cout << num;
    }
    if(open>0){
        for(int j=0; j<open; ++j){
            cout << ')';
        }
    }
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> tc;
    for(int t=1; t<=tc; ++t){
        cin >> s;
        cout << "Case #" << t << ": ";
        solve();
        cout << '\n';
    }

    return 0;
}