#include <iostream>
#include <algorithm>
#include <vector>
#include <stack>
using namespace std;

struct Line{
    int l,r;
    Line(int _l, int _r) : l(_l), r(_r){}
    bool operator<(const Line &ref)const{
        return l<ref.l;
    }
};

int n;
vector<Line> v;
int lowerBound(vector<Line> &tv, Line val){
    int left = 0;
    int right = tv.size();
    int mid;
    while(left<right){
        mid = left + (right-left)/2;
        if(val.l > tv[mid].l && val.r > tv[mid].r){
            left = mid + 1;
        }
        else{
            right = mid;
        }
    }
    return right;
}

void solve(){
    vector<Line> tv;
    vector<int> iv(n);
    for(int i=0; i<n; ++i){
        int l = v[i].l;
        int r = v[i].r;
        if(tv.empty() || (tv.back().l < l && tv.back().r < r)){
            tv.push_back(v[i]);
            iv[i] = tv.size()-1;
        }
        else{
            int idx = lowerBound(tv, v[i]);
            tv[idx] = v[i];
            iv[i] = idx;
        }
    }
    // lis로 길이를 구하고 iv에 index 를 저장한다.
    // 테케는 iv에 이렇게 들어가 있다.
    // 0 0 1 0 1 2 3 4
    // 뒤에서 부터 처음 발견하는 4 3 2 1 0 찾고 나머지는 잘라버리면 된다.
    stack<int> stk;
    int lisLen = tv.size();
    int findVal = lisLen-1;
    for(int i=n-1; i>=0; --i){
        int val = iv[i];
        if(val == findVal){
            --findVal;
        }
        else{
            stk.push(v[i].l);
        }
    }
    cout << stk.size() << '\n';
    while(!stk.empty()){
        cout << stk.top() << '\n';
        stk.pop();
    }
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n;
    for(int i=0; i<n; ++i){
        int a,b;
        cin >> a >> b;
        v.push_back(Line(a,b));
    }
    sort(v.begin(), v.end());
    solve();
    return 0;
}
