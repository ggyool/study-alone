#include <iostream>
#include <vector>
using namespace std;

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int a, b, n;
    cin >> a >> b >> n;
    int sum=0, num;
    for(int i=0; i<n; ++i){
        cin >> num;
        sum = sum*a + num;
    }
    
    vector<int> v;
    while(sum>0){
        v.push_back(sum%b);
        sum /= b;
    }
    int len = v.size();
    for(int i=0; i<len; ++i){
        cout << v[len-i-1] << ' ';
    }
    return 0;
}