#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
using namespace std;

int n;
int arr[65][65];

string reverse(int y, int x, int n,  string s)
{
    if (s.length() == 0) return "";
    char c = s[0];
    s = s.substr(1);
    if (c == '(')
    {
        for (int i = 0; i < 4; ++i)
        {
            s = reverse(y + (n/2)*(i / 2), x + (n/2)*(i % 2), n / 2, s);
        }
    }
    else if (c == ')')
    {
        //s = reverse(y, x, n, s);
    }
    else
    {
        for (int i = 0; i < n; ++i)
        {
            for (int j = 0; j < n; ++j)
            {
                arr[y + i][x + j] = c - '0';
            }
        }
    }
    return s;
}


int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(0);

    string s;
    cin >> n >> s;

    reverse(0, 0, n, s);
    for(int i=0; i<n; ++i){
        for(int j=0; j<n; ++j){
            cout << arr[i][j];
        }
        cout << '\n';
    }
    return 0;
}