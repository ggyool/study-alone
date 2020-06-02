#include <iostream>
#include <string>
#include <algorithm>
using namespace std;


// -2로 나눈 나머지가 -1 이면 몫에 1을 더한다. 왜인지는 와닿지 않음
// negative base 라는 이론이라고 한다.

int main(void){
    string s;
    int n;
    cin >> n;
    if(n==0){
        cout << 0;
        return 0;
    }
    while(n!=0){
        int r = n%-2;
        n /= -2;
        if(r==-1){
            s.push_back('1');
            n += 1;
        }else{
            s.push_back(r + '0');
        }
    }
    reverse(s.begin(), s.end());
    cout << s;
    return 0;
}
