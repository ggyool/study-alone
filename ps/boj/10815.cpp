#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int n, m;
vector<int> v;

bool isFind(int num){
    int left = 0;
    int right = n-1;
    int mid;
    while(left<=right){
        mid = left+(right-left)/2;
        if(v[mid] == num) return true;
        else if(v[mid] < num) left = mid + 1;
        else right = mid - 1;
    }
    return false;
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n;
    int num;
    for(int i=0; i<n; ++i){
        cin >> num;
        v.push_back(num);
    }
    sort(v.begin(), v.end());
    cin >> m;
    for(int i=0; i<m; ++i){
        cin >> num;
        cout << isFind(num) << ' ';
        // stl
        // cout << binary_search(v.begin(), v.end(), num) << ' ';
    }
    return 0;
}
