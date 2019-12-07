#include <iostream>
#include <algorithm>
using namespace std;

int n,m,r;
int arr[300][300];
int trr[300][300];

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    
    cin >> n >> m >> r;
    for(int i=0; i<n; ++i)
    {
        for(int j=0; j<m; ++j)
        {
            cin >> arr[i][j];
            trr[i][j] = arr[i][j];
        }
    }
    int loopn = min(n,m)/2;
    for(int b=0; b<loopn; ++b)
    {   
        for(int rr = 0; rr < r % (2*(n-2*b) + 2*(m-2*b) -4); ++rr)
        {
            int tmp1 = arr[b][b];
            int tmp2 = arr[n - 1 - b][m - 1 - b];
            for (int j = b; j < m - 1 - b; ++j)
            {
                arr[b][j] = arr[b][j + 1];
                arr[n - 1 - b][m - 1 - j] = arr[n - 1 - b][m - 2 - j];
            }
            for (int i = b; i < n - 1 - b; ++i)
            {
                arr[i][m - 1 - b] = arr[i + 1][m - 1 - b];
                arr[n - 1 - i][b] = arr[n - 2 - i][b];
                
            }
            arr[b + 1][b] = tmp1;
            arr[n - 2 - b][m - 1 - b] = tmp2;
        }
    }
    
    for(int i=0; i<n; ++i)
    {
        for(int j=0; j<m; ++j)
        {
            cout << arr[i][j] << ' ';
        }
        cout << '\n';
    }
    return 0;
}