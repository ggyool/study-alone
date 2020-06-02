#include <iostream>
#include <algorithm>
using namespace std;

int arr[100001][3];
int minArr[3];
int maxArr[3];
int n;

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n;
    for(int i=1; i<=n; ++i){
        cin >> arr[i][0];
        cin >> arr[i][1];
        cin >> arr[i][2];
    }
    for(int i=1; i<=n; ++i){
        int min01 = min(minArr[0], minArr[1]);
        int max01 = max(maxArr[0], maxArr[1]);
        int min12 = min(minArr[1], minArr[2]);
        int max12 = max(maxArr[1], maxArr[2]);
        int min012 = min(min01, min12);
        int max012 = max(max01, max12);

        minArr[0] = arr[i][0] + min01;
        maxArr[0] = arr[i][0] + max01;
        minArr[1] = arr[i][1] + min012;
        maxArr[1] = arr[i][1] + max012;
        minArr[2] = arr[i][2] + min12;
        maxArr[2] = arr[i][2] + max12;
    }
    cout << max(max(maxArr[0], maxArr[1]), maxArr[2]) << ' ';
    cout << min(min(minArr[0], minArr[1]), minArr[2]);
    

    return 0;
}