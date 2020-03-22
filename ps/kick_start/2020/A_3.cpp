#include <iostream>
#include <queue>
#include <functional>
using namespace std;

int tc, n, k;

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> tc;
    for(int t=1; t<=tc; ++t){
        priority_queue<int, vector<int>, less<int>> pq;
        cin >> n >> k;
        int num, bef;
        for(int i=0; i<n; ++i){
            cin >> num;
            if(i!=0){
                pq.push(num-bef); 
            }
            bef = num;
        }
        for(int i=0; i<k; ++i){
            int maxval = pq.top();
            if(maxval==1) break;
            pq.pop();
            if(maxval%3 == 0){
                if(!pq.empty() && pq.top() > maxval/3)
                ;
            }else{
                pq.push(maxval/2);
                pq.push(maxval-(maxval/2));
            }

            Abc a = Abc();
            Abc b  = Abc();
            a<b
            a.operator<(b);
        }
        cout << "Case #" + to_string(t) + ": " + to_string(pq.top()) << '\n'; 
    }
    return 0;
}