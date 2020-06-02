#include <iostream>
#include <algorithm>
using namespace std;

int n;
int incdp[1001];
int decdp[1001];
int arr[1001];

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n;
    for(int i=1; i<=n; ++i)
        cin >> arr[i];
    incdp[1] = 1;
    for(int i=2; i<=n; ++i){
        incdp[i] = 1;
        for(int j=1; j<=i-1; ++j){      
            if(arr[j] < arr[i])
                incdp[i] = max(incdp[i], incdp[j] + 1);
        }
    }
    decdp[n] = 1;
    for(int i=n-1; i>=1; --i){
        decdp[i] = 1;
        for(int j=i+1; j<=n; ++j){    
            if(arr[j] < arr[i])
                decdp[i] = max(decdp[i], decdp[j] + 1);
        }
    }
    // 초기화 안해서 많이 날림
    int ans = 0;
    for(int i=1; i<=n; ++i){
        ans = max(ans, incdp[i] + decdp[i] - 1);
    }
    cout << ans;
    

    return 0;
}