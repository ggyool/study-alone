#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int n, cnt;
vector<int> v;
int arr[10];
// int srr[10], brr[10];

// 1~n 숫자의 모든 조합을 뽑는 문제

void solve(int cur, int pick){
    if(pick==5){
        ++cnt;
        for(int i=0; i<5; ++i){
            cout << v[i] << ' ';
        }
        cout << '\n';
        return;
    }
    for(int i=cur+1; i<10; ++i){
        v.push_back(arr[i]);
        solve(i, pick+1);
        v.pop_back();
    }

}


int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    for(int i=0; i<10; ++i){
        arr[i] = (i+1)*10;
    }
    solve(-1, 0);
    cout << cnt;
    return 0;
}
