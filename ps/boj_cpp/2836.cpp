#include <iostream>
#include <algorithm>
#include <vector>
#include <climits>
using namespace std;


typedef long long ll;
int n, m;

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n >> m;
    ll ans = 0;
    int maxVal = m;
    // left m 보다 작은 reverse 그룹들만 처리하면 된다. 2*(right-left)
    // left right 사이에 m이 있는 경우 2*(m-left)
    vector<pair<int,int>> v;
    for(int i=0; i<n; ++i){
        int a,b;
        cin >> a >> b;
        if(a<b){
            maxVal = max(maxVal, b);
        }
        else{
            maxVal = max(maxVal, a);
            if(b<m) v.push_back({b,a});
        }
    }   
    sort(v.begin(), v.end());
    int vlen = v.size();
    int left, right;
    for(int i=0; i<vlen; ++i){
        if(i==0){
            left = v[0].first;
            right = v[0].second;
        }
        else{
            if(v[i].first<=right){
                right = max(right, min(m, v[i].second));
            }
            else{
                ans += 2*(right-left);
                left = v[i].first;
                right = min(m, v[i].second);
            }
        }
    }
    ans += 2*(right-left);
    ans += maxVal;
    cout << ans;
    return 0;
}

