#include <iostream>
#include <string>
#include <algorithm>
#include <vector>
using namespace std;

struct Score{
    int k,e,m;
    string name;
    Score(string name, int k, int e, int m){
        this->name = name;
        this->k = k;
        this->e = e;
        this->m = m;
    }
    bool operator<(const Score &ref) const{
        if(k==ref.k){
            if(e==ref.e){
                if(m==ref.m){
                    return name.compare(ref.name)<0;
                }
                return m>ref.m;
            }
            return e<ref.e;
        }
        return k>ref.k;
    }
};
int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int n;
    int k,e,m;
    string name;
    vector<Score> v;
    cin >> n;
    for(int i=0; i<n; ++i){
        cin >> name >> k >> e >> m;
        v.push_back(Score(name, k, e, m));
    }
    sort(v.begin(), v.end());
    for(int i=0; i<n; ++i){
        cout << v[i].name << '\n';
    }


    return 0;
}