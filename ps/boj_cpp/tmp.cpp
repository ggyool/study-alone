#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int n,m;
int arr[10001];
int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n >> m;
    for(int i=0; i<n; ++i){
        cin >> arr[i];
    }
    int ans = 0;
    int i=0, j=0;
    int sum = 0;
    while(j<n || sum>m){
        if(sum<m){
            sum += arr[j++];
        }
        else{
            sum -= arr[i++];
        }
        if(sum==m){
            ++ans;
        }
    }
    cout << ans;

    return 0;
}
