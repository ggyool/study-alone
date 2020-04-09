#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

void swap(int &refa, int &refb){
    int tmp = refa;
    refa = refb;
    refb = tmp;
}

// 모든것을 내림차순으로 바꿔야 한다.
// 1. v[i]-v[i-1]>0 인 위치를 뒤에서 부터 찾는다.
// 2. v[i]~끝 중 v[i-1] 보다 큰 다음 숫자를 찾는다. (v[i]가 v[i-1] 보다 크기 때문에 무조건 있다.) 
// 뒤에서 부터 찾으면 오름차순으로 찾는 것이다. 
// 3. i-1 과 찾은 값을 바꾼다.
// 4. 나머지를 뒤집는다.
bool nextPermutation(vector<int> &v){
    int len = v.size();
    for(int i=len-1; i>=1; --i){
        if(v[i]-v[i-1] > 0){
            for(int j=len-1; j>=i; --j){
                if(v[j]>v[i-1]){
                    swap(v[i-1], v[j]);
                    reverse(v.begin()+i, v.end());
                    // int k=i, l=len-1;
                    // while(k<l){
                    //     swap(v[k++], v[l--]);
                    // }
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
    if(!nextPermutation(v)) cout << -1;
    else{
        for(int i=0; i<n; ++i){
            cout << v[i] << ' ';
        }
    }
    return 0;
}
