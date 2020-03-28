#include <algorithm>
#include <iostream>
#include <vector>
using namespace std;

// nth_element 사용
int n,k;
vector<int> v;

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n >> k;
    int num;
    for(int i=0; i<n; ++i){
        cin >> num;
        v.push_back(num);
    }
    nth_element(v.begin(), v.begin()+k-1, v.end());
    cout << v[k-1];
    return 0;
}