#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int n,s; 
int arr[100001];

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n >> s;
    for(int i=0; i<n; ++i){
        cin >> arr[i];
    }
    const int INF = (int)1e9;
    int ans = INF;
    int sum = 0;
    int i=0, j=0;
    while(j<n || sum>s){
        if(sum<s){
            sum += arr[j++];
        }
        else{
            sum -= arr[i++];
        }
        if(sum>=s){
            ans = min(ans, j-i);
        }
    }
    if(ans==INF) cout << 0;
    else cout << ans;
    return 0;
}
