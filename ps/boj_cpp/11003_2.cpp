#include <iostream>
#include <map>
#include <deque>
using namespace std;

int n,l;
int arr[5000001];
deque<pair<int, int>> dq;

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    cin >> n >> l;
    for(int i=1; i<=n; ++i){
        cin >> arr[i];
        while(!dq.empty() && dq.front().first <= i-l){
            dq.pop_front();
        }
        while(!dq.empty() && dq.back().second >= arr[i]){
            dq.pop_back();
        }
        dq.push_back({i, arr[i]});
        cout << dq.front().second << ' ';
    }
    return 0;
}