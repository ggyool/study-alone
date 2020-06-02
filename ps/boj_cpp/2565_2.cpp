#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int n;
vector<pair<int,int>> v;

int lowerBound(vector<pair<int,int>> &tv, pair<int,int> p){
    int left = 0;
    int right = tv.size();
    int mid;
    while(left<right){
        mid = left + (right-left)/2;
        // 정렬 했으므로 first 는 신경 안써도 된다.
        if(tv[mid].second < p.second){
            left = mid + 1;
        }
        else{
            right = mid;
        }
    }
    return right;
}

int lis(){
    vector<pair<int, int>> tv = {v[0]};
    for(int i=1; i<n; ++i){
        int end = tv.back().second;
        if(v[i].second > end){
            tv.push_back(v[i]);
        }
        else{
            int idx = lowerBound(tv, v[i]);
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
    for(int i=0; i<n; ++i){
        int a,b;
        cin >> a >> b;
        v.push_back({a,b});
    }
    sort(v.begin(), v.end());
    cout << n-lis();
    return 0;
}
