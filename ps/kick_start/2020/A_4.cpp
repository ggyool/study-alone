#include <iostream>
#include <string>
#include <cstring>
#include <vector>
using namespace std;


int tc, n, k;
vector<string> sv;
vector<int> v;
vector<bool> visited;
vector<int> pv;

int calc(){
    
}

void pick(int idx, int pickn){
    if(pickn==n) {
        calc();
        return;
    }
    for(int i=0; i<n;++i){
        if(!visited[i]){
            visited[i] = true;
            pick(i, pickn+1);
            visited[i] = false;
        }
    }
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> tc;
    for(int t=1; t<=tc; ++t){
        cin >> n >> k;
        sv = vector<string>(n);
        v = vector<int>(n);
        pv = vector<int>(n);
        visited = vector<bool> (n,false);
        for(int i=0; i<n; ++i){
            cin >> sv[i];
        }
        
        for(int i=0; i<n; ++i){

        }

    }
    return 0;
}