#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

// 어떻게 한방에 맞았다?
// 그리디문제라고 판단하고 풀었다.
// 큰수-작은수 또는 작은수-큰수가 값이 크게 나오므로
// 큰 작 큰 작 으로 뽑는것을 기본 아이디어로 하여
// 6가지만 계산했다.
// 홀수개
// ? 큰 작 큰 작
// 큰 작 큰 작 ?
// ? 작 큰 작 큰 // 이것저것 제출해보니 안해도 정답
// 작 큰 작 큰 ? // 이것저것 제출해보니 안해도 정답
// 짝수개
// ? 큰 작 큰 작 ?
// ? 작 큰 작 큰 ?

typedef long long ll;
vector<int> tv;
vector<int> v;
int n;


int abs(int num){
    if(num<0) return -1*num;
    return num;
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);    
    cin >> n;
    for(int i=0; i<n; ++i){
        int num;
        cin >> num;
        v.push_back(num);
    }
    sort(v.begin(), v.end());
    if(n&1){
        int i = 0;
        int j = n-1;
        ll ans = 0;
        ll sum = 0;
        while(true){
            sum += abs(v[j--]-v[i]);
            if(j==n/2) {
                ans = sum + max(abs(v[n-1]-v[n/2]), abs(v[i]-v[n/2]));
                break;
            }
            sum += abs(v[j]-v[i++]);
        }
        sum = 0, i=0, j=n-1;
        while(true){
            sum += abs(v[j]-v[i++]);
            if(i==n/2) {
                ans = max(ans, sum + max(abs(v[j]-v[n/2]), abs(v[0]-v[n/2])));
                break;
            }
            sum += abs(v[j--]-v[i]);
        }
        cout << ans;
    }
    else{
        int i = 0;
        int j = n-1;
        ll ans = 0;
        ll sum = 0;
        while(true){
            sum += abs(v[j--]-v[i]);
            if(j==n/2) {
                // 왼쪽에 중간 둘 중 작은 값
                ans = max(ans, sum + abs(v[n-1]-v[i+1]) + abs(v[i]-v[j]));
                break;
            }
            sum += abs(v[j]-v[i++]);
        }
        // sum = 0, i=0, j=n-1;
        // while(true){
        //     sum += abs(v[j]-v[i++]);
        //     if(i==n/2-1) {
        //         // 왼쪽에 둘 중 큰 값
        //         ans = max(ans, sum + abs(v[0]-v[j-1]) + abs(v[j]-v[i]));
        //         break;
        //     }
        //     sum += abs(v[j--]-v[i]);
        // }
        cout << ans;
    }
    return 0;
}



