#include <iostream>
#include <algorithm>
using namespace std;

typedef long long int lld;
lld a,b,c;

lld mult(lld n, lld m)
{
    if(m==0) return 1;
    if(m==1) return n;
    if(m%2==0)
    {
        lld val = mult(n, m/2);
        return (val*val) % c;
    }   
    else
        return (mult(n, m - 1) * n) % c;
}

lld mult2(lld a, lld b)
{
    lld ret = 1;
    lld prod = a;
    while(b)
    {
        int mod = b%2;
        b /= 2;
        if(mod)
        {
            ret *= prod;
        }
        prod *= prod;
        prod %= c;  // 없으면 틀림 
        ret %= c;
    }
    return ret;
}

int main(void)
{
    cin >> a >> b >> c;
    cout << mult2(a%c,b);
    return 0;
}