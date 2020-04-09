#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
using namespace std;


int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    vector<int> v;
    for(int i=1; i<5; ++i){
        v.push_back(i);
    }
    do{
        for(int i=0; i<5; ++i){
            cout << v[i] << ' ';
        }
        cout << '\n';
    }while(next_permutation(v.begin(), v.end()));
    return 0;
}