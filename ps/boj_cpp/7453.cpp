#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;


int arr[4000], brr[4000], crr[4000], drr[4000];
int n;
vector<int> va,vb;

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n;
    for(int i=0; i<n; ++i){
        cin >> arr[i] >> brr[i] >> crr[i] >> drr[i];
    }
    for(int i=0; i<n; ++i){
        for(int j=0; j<n; ++j){
            va.push_back(arr[i] + brr[j]);
            vb.push_back(crr[i] + drr[j]);
        }
    }
    sort(va.begin(), va.end());
    sort(vb.begin(), vb.end());
    int alen = va.size();
    int blen = vb.size();
    int i = 0;
    int j = blen-1;
    long long ans = 0;
    while(i<alen && j>=0){
        int a = va[i];
        int b = vb[j];
        int sum = va[i] + vb[j];
        if(sum==0){
            ++i, --j;
            int acnt = 1;
            int bcnt = 1;
            while(i<alen && va[i]==a){
                ++i, ++acnt;
            }
            while(j>=0 && vb[j]==b){
                --j, ++bcnt;
            }
            ans += ((long long)acnt*bcnt);
        }
        else if(sum>0){
            --j;
        }
        else{
            ++i;
        }
    }
    cout << ans;
    return 0;
}
