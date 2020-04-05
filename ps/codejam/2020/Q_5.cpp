#include <algorithm>
#include <iostream>
#include <cstring>
using namespace std;

// Wrong Answer
int tc, n, k;
int arr[50][50];

void solve(){
    for(int i=0; i<n; ++i){
        arr[i][i] = k/n;
        int j = i + 1;
        int num = 1;
        for(int l=0; l<n; ++l){
            if(num==k/n) {
                ++num;
                continue;
            }
            j %= n;
            arr[i][j++] = num++;
        }
    }
}

void printArr(){
    for(int i=0; i<n; ++i){
        for(int j=0; j<n; ++j){
            cout << arr[i][j] << ' ';
        }
        cout << '\n';
    }
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> tc;
    for(int t=1; t<=tc; ++t){
        cin >> n >> k;
        cout << "Case #" << t << ": ";
        if(k%n==0){
            cout << "POSSIBLE\n";
            solve();
            printArr();
        }
        else cout << "IMPOSSIBLE";
        cout << '\n';
    }

    return 0;
}