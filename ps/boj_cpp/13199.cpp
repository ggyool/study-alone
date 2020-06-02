#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

typedef long long ll;
ll tc, p,m,f,c;

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> tc;
    while(tc--){
        cin >> p >> m >> f >> c;
        ll doo = (m/p * c)/f;
        // f-c개로 치킨을 먹는 효과! f개 미만으로 내려가면 세면 안된다.
        // (m/p*c) 에서 f 를 빼서 나누고(확실) 남은 것들로 하나를 시킨다.
        ll sang;
        if(m/p*c-f>=0)
            sang = (m/p*c-f)/(f-c) + 1;
        else
            sang = doo;
        cout << sang-doo << '\n';
    }
    // 10 3 2
    // +3 7
    // +2 5
    // +1 4
    // +1 3
    // +1 2

    return 0;
}
