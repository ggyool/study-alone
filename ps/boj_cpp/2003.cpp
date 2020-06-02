#include <iostream>
using namespace std;

int n,m;
int arr[10001];

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n >> m;
    for(int i=0; i<n; ++i)
        cin >> arr[i];
    int sum, ans=0;
    for(int i=0; i<n; ++i){
        for(int j=i; j<n; ++j){
            if(i==j) sum = arr[i];
            else{
                sum += arr[j];
            }
            if(sum==m) ++ans;
            else if(sum>m) break;
        }
    }    
    cout << ans;
    return 0;
}