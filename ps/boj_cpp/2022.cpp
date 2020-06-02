#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <cstring>
#include <cmath>
using namespace std;

// c = h1*h2/(h1+h2);
double x,y,c;

double solve(){
    double left = 0.;
    double right = min(x, y);
    double mid;
    while(abs(right-left)>1e-6){
        mid = (left+right)/2;
        double h1 = sqrt(x*x-mid*mid);
        double h2 = sqrt(y*y-mid*mid);
        double h = h1*h2/(h1+h2);
        if(h>c){
            left = mid;
        }
        else {
            right = mid;
        }
    }
    return mid;
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> x >> y >> c;
    cout << solve();
    return 0;
}

