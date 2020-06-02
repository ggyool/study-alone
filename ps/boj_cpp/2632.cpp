#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int p,n,m;
int suma, sumb;
vector<int> va, vb, ga, gb;
// psum
int psa[1000], psb[1000];

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
                ga.push_back(psa[j]-psa[i]+va[i]);
            }
            else{
                if(i-j>=2){          
                    ga.push_back(suma - (psa[i-1]-psa[j+1]+va[j+1]));
                }
            }
        }
    }
    for(int i=0; i<m; ++i){
        for(int j=0; j<m; ++j){
            if(j>=i){
                gb.push_back(psb[j]-psb[i]+vb[i]);
            }
            else{
                if(i-j>=2){          
                    gb.push_back(sumb - (psb[i-1]-psb[j+1]+vb[j+1]));
                }
            }
        }
    }
    
    ga.push_back(0);
    gb.push_back(0);
    sort(ga.begin(), ga.end());
    sort(gb.begin(), gb.end());

    int ans = 0;
    int alen = ga.size();
    int blen = gb.size();
    int i = 0, j = blen-1;
    while(i<alen && j>=0){
        if(ga[i] + gb[j] == p){
            int tmpa = ga[i];
            int tmpb = gb[j];
            int acnt = 1, bcnt = 1;
            ++i, --j;
            while(i<alen && tmpa==ga[i]){
                ++i;
                ++acnt;
            }
            while(j>=0 && tmpb==gb[j]){
                --j;
                ++bcnt;
            }
            ans += (acnt*bcnt);
        }
        else if(ga[i] + gb[j] > p){
            --j;
        }
        else{
            ++i;
        }
    }
    cout << ans;


    return 0;
}
