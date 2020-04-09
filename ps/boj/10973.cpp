#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

void swap(int &refa, int &refb){
    int tmp = refa;
    refa = refb;
    refb = tmp;
}

bool prevPermutation(vector<int> &v){
    int len = v.size();
    for(int i=len-1; i>=1; --i){
        if(v[i-1]-v[i]>0){
            for(int j=len-1; j>=i; --j){
                if(v[j]<v[i-1]){
                    swap(v[j], v[i-1]);
                    reverse(v.begin()+i, v.end());
                    return true;
                }
            }
        }
    }
    return false;
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int n;
    vector<int> v;  
    cin >> n;
    for(int i=0; i<n; ++i){
        int num;
        cin >> num;
        v.push_back(num);
    }
    if(!prevPermutation(v)) cout << -1;
    else{
        for(int i=0; i<n; ++i){
            cout << v[i] << ' ';
        }
    }
    return 0;
}

