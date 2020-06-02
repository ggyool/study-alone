#include <iostream>
using namespace std;

// two pointer 
int n,m;
int arr[10001];

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n >> m;
    for(int i=0; i<n; ++i)
        cin >> arr[i];
    int ans = 0;
    int i=0, j=0;
    int sum = 0;
    while(true){
        if(sum == m){
            ++ans;
            sum -= arr[i];
            ++i;
        }
        else if(sum > m){
            sum -= arr[i];
            ++i;
            
        }
        else{
            sum += arr[j];
            ++j;
        }
        if(j==n && sum<m) break;
    }
    cout << ans;
    return 0;
}