#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

// greedy 하게 풀었음, 먼 쪽부터 채우는게 맞다고 생각했음 
struct Node{
    int x, val;
    Node(int _x, int _val){
        x = _x, val = _val;
    }
    bool operator<(const Node& ref) const{
        return x < ref.x;
    }
};

int n, k, s, sidx, slen, blen;
vector<Node> sv; // small
vector<Node> bv; // big

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n >> k >> s;
    for(int i=0; i<n; ++i){
        int x, val;
        cin >> x >> val;
        if(x < s) sv.push_back(Node(x, val));
        else if(x > s) bv.push_back(Node(-x, val));
    }
    sort(sv.begin(), sv.end());
    sort(bv.begin(), bv.end());
    slen = sv.size();
    blen = bv.size();
    long long int dist = 0;
    int diff = 0;
    int cur = k; // 남은 자리
    for(int i=0; i<slen; ++i){
        int x = sv[i].x;
        diff = max(diff, s - x);
        int val = sv[i].val;
        if(cur >= val){
            cur -= val;
        }
        else{
            dist += 2*diff;
            sv[i].val -= cur;
            cur = k;
            diff = 0;
            --i;     
        }
        
    } 
    dist += 2*diff;
    diff = 0;
    cur = k;
    for(int i=0; i<blen; ++i){
        int x = bv[i].x;
        diff = max(diff, -s - x);
        int val = bv[i].val;
        if(cur >= val){
            cur -= val;
        }
        else{
            dist += 2*diff;
            bv[i].val -= cur;
            cur = k;
            diff = 0;
            --i;     
        }
    }
    dist += 2*diff;
    cout << dist;

    return 0;
}
