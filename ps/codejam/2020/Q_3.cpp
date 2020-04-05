#include <iostream>
#include <string>
#include <cstring>
#include <stack>
#include <algorithm>
#include<vector>
using namespace std;

int tc, n;


// e를 우선순위로 정렬하면 오답이 뜨는 이유를 모르겠다.
struct Activity{
    int s, e, i;
    Activity(int _s, int _e, int _i) : s(_s), e(_e), i(_i){}
    bool operator<(const Activity &ref) const{
        // if(e==ref.e) return s<ref.s;
        // return e<ref.e;
        if(s==ref.s) return e<ref.e;
        return s<ref.s;
    }
};

string solve(){
    cin >> n;
    vector<Activity> v;
    for(int i=0; i<n; ++i){
        int a,b;
        cin >> a >> b;
        v.push_back(Activity(a,b,i));
    }
    sort(v.begin(), v.end());
    string ret(n, 0);
    int c = 0, j = 0; 
    for(int i=0; i<n; ++i){
        if(j<=v[i].s) {
            ret[v[i].i] = 'J';
            j = v[i].e;
        }
        else if(c<=v[i].s){
            ret[v[i].i] = 'C';
            c = v[i].e;
        }
        else{
            ret = "IMPOSSIBLE";
            break;
        }
    }
    return ret;
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> tc;
    for(int t=1; t<=tc; ++t){
        cout << "Case #" << t << ": ";
        cout << solve();
        cout << '\n';
    }

    return 0;
}