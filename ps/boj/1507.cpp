#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

struct Edge{
    int x,y,cost;
    Edge(int _x, int _y, int _cost){
        x = _x, y = _y, cost = _cost;
    }
};


int n;
int arr[21][21];


int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n;
    for(int i=1; i<=n; ++i){
        for(int j=1; j<=n; ++j){
            cin >> arr[i][j];
            if(i!=j){
                
            }
        }
    }

    return 0;
}
