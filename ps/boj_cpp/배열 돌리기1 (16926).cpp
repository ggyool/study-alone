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
        }
    }
    int loopn = min(n,m)/2;
    while(r--)
    {
        for(int b=0; b<loopn; ++b)
        {
            for(int j=b; j<=m-1-b; ++j)
            {
                if(j!=m-1-b)
                    trr[b][j] = arr[b][j+1];
                if(j!=b)
                    trr[n-1-b][j] = arr[n-1-b][j-1];
            }
            for(int i=b; i<=n-1-b; ++i)
            {
                if(i!=b)
                    trr[i][b] = arr[i-1][b];
                if(i!=n-1-b)
                    trr[i][m-1-b] = arr[i+1][m-1-b];
            }
        }
        for(int i=0; i<n; ++i)
        {
            for(int j=0; j<m; ++j)
            {
                arr[i][j] = trr[i][j];
            }
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