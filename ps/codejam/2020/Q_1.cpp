#include <iostream>
#include <cstring>
using namespace std;

int n;
int tc;
int arr[100][100];
int cnt[101];

int s1(){
    int ret = 0;
    for(int i=0; i<n; ++i){
        ret += arr[i][i];
    }
    return ret;
}

int s2(){
    int ret = 0;
    for(int i=0; i<n; ++i){
        memset(cnt, 0, sizeof(cnt));
        bool flag = true;
        for(int j=0; j<n; ++j){
            ++cnt[arr[i][j]];
            if(cnt[arr[i][j]]>=2) {
                flag = false;
                break;
            }
        }
        ret += !flag;
    }
    return ret;
}

int s3(){
    int ret = 0;
    for(int i=0; i<n; ++i){
        memset(cnt, 0, sizeof(cnt));
        bool flag = true;
        for(int j=0; j<n; ++j){
            ++cnt[arr[j][i]];
            if(cnt[arr[j][i]]>=2) {
                flag = false;
                break;
            }
        }
        ret += !flag;
    }

    return ret;
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> tc;
    for(int t=1; t<=tc; ++t){
        cin >> n;
        for(int i=0; i<n; ++i){
            for(int j=0; j<n; ++j){
                cin >> arr[i][j];
            }
        }
        cout << "Case #" << t << ": ";
        cout << s1() << ' ' << s2() << ' ' << s3() << '\n';
    }

    return 0;
}