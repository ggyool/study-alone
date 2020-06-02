#include <iostream>
#include <algorithm>
#include <functional>
using namespace std;

// 문제가 좀 이상한듯;;
int n;
int  arr[1500*1500];

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n;
    for(int i=0; i<n; ++i){
        for(int j=0; j<n; ++j){
            cin >> arr[n*i+j];
        }
    }
    sort(arr, arr+n*n, greater<int>());
    cout << arr[n-1];

    
    return 0;
}