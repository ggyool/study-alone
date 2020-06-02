#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int n;
vector<int> v;

int lowerBound(int num, vector<int> &tv){
    int left = 0;
    int right = tv.size();
    int mid;
    // return right
    while(left<right){
        mid = left + (right-left)/2;
        if(num > tv[mid]){
            left = mid + 1;
        }
        else{
            right = mid;
        }
    }
    return right;
}

int LIS(){
    vector<int> tv = {v[0]};
    int len = v.size();
    for(int i=1; i<len; ++i){
        if(tv.back()<v[i]){
            tv.push_back(v[i]);
        }
        else{
            int idx = lowerBound(v[i], tv);
            tv[idx] = v[i];
        }
    }
    return tv.size();
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n;
    v = vector<int>(n);
    for(int i=0; i<n; ++i){
        cin >> v[i];
    }
    cout << LIS();
    return 0;
}
