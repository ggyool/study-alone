#include <iostream>
#include <stack>
#include <vector>
#include <algorithm>
using namespace std;


int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int n, num;
    stack<pair<int, int>> stk;
    cin >> n;
    vector<int> v = vector<int>(n);
    for(int i=0; i<n; ++i)
    {
        cin >> num;
        if(stk.empty() || stk.top().second >= num)
        {
            stk.push(make_pair(i,num));
        }     
        else
        {
            while(!stk.empty() && stk.top().second < num)
            {
                v[stk.top().first] = num;
                stk.pop();
            }
            stk.push(make_pair(i, num));
        }
    }
    while(!stk.empty())
    {
        v[stk.top().first] = -1;
        stk.pop();
    }
    for(int i=0; i<n; ++i)
    {
        cout << v[i] << ' ';
    }
    return 0;
}