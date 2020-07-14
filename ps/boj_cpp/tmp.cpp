#include <iostream>
#include <vector>
#include <queue>
using namespace std;


int main(void){
    queue<long long> q;
    for(int i=0; i<=9; ++i){
        q.push(i);
    }
    int cnt = 0;
    while(!q.empty()){
        long long cur = q.front();
        ++cnt;
        q.pop();
        cout << cur << '\n';
        if(cnt==(int)1e6) break;
        for(int i=0; i<cur%10; ++i){
            q.push(10*cur + i);
        }
    }
    cout << cnt;
    return 0;
}