#include <string>
#include <vector>
#include <iostream>

using namespace std;
// 사이사이에 0101순으로 넣으면 될듯?
vector<int> solution(int n) {
    vector<int> v = {0};
    
    for(int i=2; i<=n; ++i){
        vector<int> tmp;
        for(int j=0; j<v.size()+1; ++j){
            if(j%2==0) tmp.push_back(0);
            else tmp.push_back(1);
            if(j!=v.size()) tmp.push_back(v[j]);
        }
        v = tmp;
    }
    return v;
}

int main(void){
    vector<int> v = solution(3);
    for(int a : v){
        cout << a << ' ';
    }
    return 0;
}
