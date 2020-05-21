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
    // sum>m 안 넣으면 틀림
    // 마지막 큰 숫자가 추가되면서 sum 이 커지는 경우
    // i를 증가시켜서 m을 만들 가능성이 있으나 무시된다.
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
