#include <iostream>
#include <map>
#include <queue>
using namespace std;

struct Info{
    int val, idx;
    Info(int _val, int _idx){
        val = _val;
        idx = _idx;
    }
    bool operator<(const Info &ref) const{
        if(val==ref.val) return idx>ref.idx;
        return val>ref.val;    
    }
};

int n,l;
int arr[5000001];
priority_queue<Info> pq;

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    cin >> n >> l;
    for(int i=1; i<=n; ++i){
        cin >> arr[i];
        pq.push(Info(arr[i], i));
        while(!pq.empty() && pq.top().idx<=i-l){
            pq.pop();
        }
        cout << pq.top().val << ' ';
    }
    return 0;
}