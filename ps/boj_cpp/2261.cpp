#include <iostream>
#include <algorithm>
#include <vector>
#include <cmath>
#include <set>
using namespace std;

struct Pos{
    int y,x;
    Pos(){}
    Pos(int _y, int _x) : y(_y), x(_x){}
    bool operator<(const Pos &ref) const{
        if(y == ref.y) return x < ref.x;
        return y< ref.y;
    }
};

bool xcmp(const Pos &refa, const Pos &refb){
    return refa.x<refb.x;
}

int calcDist(const Pos &pa, const Pos &pb){
    return (pa.y-pb.y)*(pa.y-pb.y) + (pa.x-pb.x)*(pa.x-pb.x);
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int n;
    cin >> n;
    vector<Pos> xv(n);
    for(int i=0; i<n; ++i){
        cin >> xv[i].x >> xv[i].y;
    }   
    sort(xv.begin(), xv.end(), xcmp);
    set<Pos> st = {xv[0], xv[1]};
    int minDist = calcDist(xv[0], xv[1]);
    int start = 0;
    for(int i=2; i<n; ++i){
        Pos cur = xv[i];    
        while(start<i){
            Pos tar = xv[start];
            int subx = (cur.x-tar.x)*(cur.x-tar.x);
            // 같아도 지워도 된다고 생각
            if(subx>=minDist){
                st.erase(tar);
                ++start;
            }
            else{
                break;
            }
        }   
        // 예시 코드에서 d+1 한 이유를 잘 모르겠다.
        int d = (int)sqrt((double)minDist);
        auto lowerIt = st.lower_bound(Pos(cur.y-d , -1000000));
        auto upperIt = st.upper_bound(Pos(cur.y+d , 1000000));
        for(auto it=lowerIt; it!=upperIt; ++it){
            int dist = calcDist(cur, *it);
            minDist = min(minDist, dist);
        }
        st.insert(cur);
    }
    cout << minDist << '\n';
    return 0;
}
 