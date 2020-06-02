#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;


int m,n,l;
vector<int> turrets;

vector<pair<int, int>> animals;


int lowerBound(vector<int> &v, int val){
    int left = 0;
    int right = v.size();
    int mid;
    while(left<right){
        mid = left +(right-left)/2;
        if(v[mid] < val){
            left = mid + 1;
        }
        else{
            right = mid;
        }
    }
    return right;
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> m >> n >> l;
    for(int i=0; i<m; ++i){
        int a;
        cin >> a;
        turrets.push_back(a);
    }
    for(int i=0; i<n; ++i){
        int x,y;
        cin >> x >> y;
        // x, y
        animals.push_back({x, y});
    }
    sort(turrets.begin(), turrets.end());
    sort(animals.begin(), animals.end());
    int tlen = turrets.size();
    int ans = 0;
    for(int i=0; i<n; ++i){
        int ax = animals[i].first;
        int ay = animals[i].second;
        int idx = lowerBound(turrets, ax);
        // 동물보다 오른쪽에 있거나 x가 같은 경우 체크
        // 모든 터렛위치가 동물보다 작은 경우는 제외 해야한다.
        if(idx<tlen){
            int tx = turrets[idx];
            if(ay+tx-ax<=l){
                ++ans;
                continue;
            }
            // 같은 x인 경우 왼쪽 안 봐도 된다.
            if(tx==ax) continue;
        }
        // 왼쪽 체크
        if(idx!=0){
            int tx = turrets[idx-1];
            if(ay+ax-tx<=l) ++ans;
        }
    }
    cout << ans;
    return 0;
}
