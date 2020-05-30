#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

vector<int> sa, sb;
vector<int> pa, pb;
int t,n,m, alen, blen;

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);    
    cin >> t >> n;
    int sum = 0;
    for(int i=0; i<n; ++i){
        int num;
        cin >> num;
        sum += num;
        sa.push_back(sum);
    }
    cin >> m;
    sum = 0;
    for(int i=0; i<m; ++i){
        int num;
        cin >> num;
        sum += num;
        sb.push_back(sum);
    }

    alen = sa.size();
    blen = sb.size();
    for(int i=0; i<alen; ++i){
        for(int j=i; j<alen; ++j){
            if(i==0) pa.push_back(sa[j]);
            else pa.push_back(sa[j] - sa[i-1]);
        }
    }

    for(int i=0; i<blen; ++i){
        for(int j=i; j<blen; ++j){
            if(i==0) pb.push_back(sb[j]);
            else pb.push_back(sb[j] - sb[i-1]);
        }
    }
    
    alen = pa.size();
    blen = pb.size();
    sort(pa.begin(), pa.end());
    sort(pb.begin(), pb.end());
    // 예를 들면 다 0 인 케이스를 보면
    // pa는 0이 백만개, pb에도 0이 백만개라서 long long 해야한다.
    long long ans = 0;
    int i = 0, j = blen - 1;
    // i<alen && blen>0 라고 실수해서 계속 에러
    while(i<alen && j>=0){
        if(pa[i]+pb[j] == t){
            int ta = pa[i];
            int tb = pb[j];
            long long ca = 1;
            long long cb = 1;
            ++i, --j;
            while(i<alen && ta==pa[i]){
                ++i;
                ++ca;
            }
            while(j>=0 && tb==pb[j]){
                --j;
                ++cb;
            }
            ans += ca*cb;
        }
        else if(pa[i]+pb[j] > t){
            --j;
        }
        else{
            ++i;
        }
    }
    cout << ans;
    return 0;
}
