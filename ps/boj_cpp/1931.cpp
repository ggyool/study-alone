#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

struct Meeting{
    int start,end;
    Meeting(int start, int end) : start(start), end(end){}
    bool operator<(const Meeting &ref) const{
        if(end==ref.end) {
            // 1 4
            // 4 5
            // 5 5 같은 케이스
            return start<ref.start;
        }
        return end<ref.end;
    }
};

vector<Meeting> v;
int n;

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n;
    for(int i=0; i<n; ++i){
        int a,b;
        cin >> a >> b;
        v.push_back(Meeting(a,b));
    }
    sort(v.begin(), v.end());
    Meeting cur = v[0];
    int cnt = 1;
    for(int i=1; i<n; ++i){
        Meeting target = v[i];
        if(target.start>=cur.end){
            cur = target;
            ++cnt;
        }
    }
    cout << cnt;
    return 0;
}
