#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;


const int BIG = 987654321;
int n,m;
vector<int> v;

// return right 와 left<right 만 기억하면 시간절약 될듯


// return right
int lowerBound(int num){
    int left = 0;
    // num이 모든 값들 보다 크면 +1 을 n을 return 한다.
    int right = n;
    int mid;
    while(left<right){
        mid = left + (right-left)/2;
        if(num<=v[mid]) right = mid;
        else if(num>v[mid]) left = mid+1;
    }
    return right;
}

int upperBound(int num){
    int left = 0;
    int right = n;
    int mid;
    while(left<right){
        mid = left + (right-left)/2;
        if(num<v[mid]) right = mid;
        else if(num>=v[mid]) left = mid + 1;
    }
    return right;
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
        /*int a = lowerBound(num);
        int b = upperBound(num);
        cout << b-a << ' ';*/
        // stl
        //cout << upper_bound(v.begin(), v.end(), num) - lower_bound(v.begin(), v.end(), num) << ' ';
        auto res = equal_range(v.begin(), v.end(), num);
        cout << res.second - res.first << ' ';
    }
    return 0;
}
