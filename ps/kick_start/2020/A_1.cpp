#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int tc, n, s;
vector<int> v;

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> tc;
    for(int t=1; t<=tc; ++t){
        cin >> n >> s;
        v = vector<int> (n);
        for(int i=0; i<n; ++i){
            cin >> v[i];
        }
        sort(v.begin(), v.end());
        int ans = -1;
        for(int i=0; i<n; ++i){
            if(s >= v[i]){
                s -= v[i];
                ans = i;
            }
            else break;
        }
        cout << "Case #" + to_string(t) + ": " + to_string(ans+1) << '\n';
    }
    return 0;
}