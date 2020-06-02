#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int p,n,m;
int suma, sumb;
vector<int> va, vb;
// psum
int psa[1000], psb[1000];
int cnta[2000001];

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> p >> n >> m;
    for(int i=0; i<n+m; ++i){
        int num;
        cin >> num;
        if(i<n){
            suma += num;
            va.push_back(num);
        }
        else{
            sumb += num;
            vb.push_back(num);
        }
    }
    psa[0] = va[0];
    psb[0] = vb[0];
    for(int i=1; i<n; ++i){
        psa[i] = psa[i-1] + va[i];
    }
    for(int i=1; i<m; ++i){
        psb[i] = psb[i-1] + vb[i];
    }
    // i조각 부터 j조각 까지 합
    // i>j인경우 전체에서 빼는 아이디어 sum - (j+1~i-1)
    for(int i=0; i<n; ++i){
        for(int j=0; j<n; ++j){
            if(j>=i){
                ++cnta[psa[j]-psa[i]+va[i]];
            }
            else{
                if(i-j>=2){          
                    ++cnta[suma - (psa[i-1]-psa[j+1]+va[j+1])];
                }
            }
        }
    }
    int ans = cnta[p];
    cnta[0] = 1;
    for(int i=0; i<m; ++i){
        for(int j=0; j<m; ++j){
            int val;
            if(j>=i){
                val = psb[j]-psb[i]+vb[i];
                if(p-val>=0)
                    ans += cnta[p - val];
            }
            else{
                if(i-j>=2){          
                    val = sumb - (psb[i-1]-psb[j+1]+vb[j+1]);
                    if(p-val>=0)
                        ans += cnta[p - val];
                }
            }
        }
    }
    cout << ans;
    return 0;
}
