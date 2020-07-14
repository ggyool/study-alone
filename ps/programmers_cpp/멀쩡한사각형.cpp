#include <algorithm>
#include <iostream>
using namespace std;

long long gcd(long long a, long long b){
    if(b==0) return a;
    return gcd(b, a%b);
}

long long solution(int w,int h) {   
    long long g = gcd(w,h);
    // overflow
    return (long long)w*h - (w+h-g);   
}


int main(void){
    cout << solution(7,1);
    
    return 0;
}