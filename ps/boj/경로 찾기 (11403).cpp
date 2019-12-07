#include <iostream>
#include <algorithm>
using namespace std;

int n;
int conn[100][100];

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n;
    for (int i = 0; i < n; ++i)
    {
        for (int j = 0; j < n; ++j)
        {
            cin >> conn[i][j];
        }
    }
    for (int k = 0; k < n; ++k)
    {
        for (int i = 0; i < n; ++i)
        {
            for (int j = 0; j < n; ++j)
            {
                // 플로이드 응용
                // k-1포함 방문했거나 or k포함 방문하거나
                conn[i][j] = conn[i][j] | (conn[i][k] & conn[k][j]);
            }
        }
    }
    for (int i = 0; i < n; ++i)
    {
        for (int j = 0;j < n; ++j)
        {
            cout << conn[i][j] << ' ';
        }
        cout << '\n';
    }
    return 0;
}
