#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

struct Pos{
    int x,y;
    Pos(int a, int b) : x(a), y(b){}
    bool operator<(const Pos &ref) const{
        if(x==ref.x) return y<ref.y;
        return x<ref.x;
    }
};

vector<Pos> v;
int n;

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n;
    for(int i=0; i<n; ++i){
        int x,y;
        cin >> x >> y;
        v.push_back(Pos(x,y));
    }
    sort(v.begin(), v.end());
    for(int i=0; i<n; ++i){
        cout << v[i].x << ' ' << v[i].y << '\n';
    }
    return 0;
}
