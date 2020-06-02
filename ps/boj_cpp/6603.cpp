#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int k, num;
int arr[13];

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    while(true){
        cin >> k;
        if(k==0) break;
        for(int i=0; i<k; ++i){
            cin >> arr[i];
        }
        // 0을 뽑는 숫자, 1을 안 뽑는 숫자
        vector<int> v = {0,0,0,0,0,0};
        for(int i=0; i<k-6; ++i){
            v.push_back(1);
        }
        do{
            for(int i=0; i<k; ++i){
                if(v[i]==0){
                    cout << arr[i] << ' ';
                }
            }
            cout << '\n';
        }while(next_permutation(v.begin(), v.end()));
        cout << '\n';
    }
    return 0;
}
