#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <cstring>
using namespace std;

int arr[100][100];
int brr[100][100];
int res[100][100];

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int n,m,k;
    cin >> n >> m;
    for(int i=0; i<n; ++i){
        for(int j=0; j<m; ++j){
            cin >> arr[i][j];
        }
    }
    cin >> m >> k;
    for(int i=0; i<m; ++i){
        for(int j=0; j<k; ++j){
            cin >> brr[i][j];
        }
    }

    for(int i=0; i<n; ++i){
        for(int j=0; j<m; ++j){
            for(int l=0; l<k; ++l){
                res[i][l] += arr[i][j] * brr[j][l];
            }
        }
    }
    for(int i=0; i<n; ++i){
        for(int j=0; j<k; ++j){
            cout << res[i][j] << ' ';
        }
        cout << '\n';
    }
    return 0;
}

