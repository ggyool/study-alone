#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

typedef long long ll;
int n;
vector<int> v;

ll mergeSolve(int left, int right){
    if(left>=right) return 0;
    int mid = left +(right-left)/2;
    ll ret = mergeSolve(left, mid);
    ret += mergeSolve(mid+1, right);
    vector<int> tv;
    int i = left, j = mid+1;
    while(i<=mid && j<=right){
        if(v[i]>v[j]){
            ret += mid-i+1;
            tv.push_back(v[j++]);
        }
        else {
            tv.push_back(v[i++]);
        }
    }
    while(i<=mid){
        tv.push_back(v[i++]);
    }
    while(j<=right){
        tv.push_back(v[j++]);
    }
    int tlen = tv.size();
    for(int i=0; i<tlen; ++i){
        v[left+i] = tv[i];
    }
    return ret;
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
    cout << mergeSolve(0, n-1);
    return 0;
}

