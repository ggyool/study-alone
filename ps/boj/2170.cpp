#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int n;
vector<pair<int, int>> pv;

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n;
    for(int i=0; i<n; ++i){
        int a,b;
        cin >> a >> b;
        pv.push_back({a,b});        
    }
    sort(pv.begin(), pv.end());
    int ans = 0;
    int mins = pv[0].first;;
    int maxe = pv[0].second;
    for(int i=0; i<n; ++i){
        int s = pv[i].first;
        int e = pv[i].second;
        if(s<=maxe){
            maxe = max(maxe, e);
        }
        else{
            ans += maxe-mins;
            mins = s;
            maxe = e;
        }
    }
    ans += maxe-mins;
    cout << ans;
    return 0;
}
