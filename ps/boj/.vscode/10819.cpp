#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

vector<int> v;
vector<int> tv;
vector<bool> visited;
int n;

int calc(){
    int ret = 0;
    for(int i=0; i<n-1; ++i){
        int sub = tv[i] - tv[i+1];
        if(sub<0) sub *= -1;
        ret += sub;
    }
    return ret;
}

int pick(){
    if(tv.size() == n){
        return calc();
    }
    int ret = 0;
    for(int i=0; i<n; ++i){
        if(visited[i]==false){
            visited[i] = true;
            tv.push_back(v[i]);
            ret = max(ret, pick());
            visited[i] = false;
            tv.pop_back();
        }
    }
    return ret;
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);    
    cin >> n;
    for(int i=0; i<n; ++i){
        int num;
        cin >> num;
        v.push_back(num);
    }
    visited = vector<bool>(n);
    cout << pick();
    return 0;
}

