#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

const int MAX = 290000;
// i조각 까지 사용한 높이 차이 j, 값 높은 높이
int dp[51][MAX+1];
int arr[51];
int n;

// 490000 1 1 이런 케이스가 있는게 아닐까 ?

int main(void){
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	cin >> n;
	for(int i=1; i<=n; ++i){
		cin >> arr[i];
		// 높이차이가 0인것들이 정답 후보군인데, 아무것도 안 놓은 0 0 도 생기므로
		// 처음에 초기화 했다.
		dp[i][arr[i]] = arr[i];
	}   
	
	for(int i=2; i<=n; ++i){
		int h = arr[i];
		for(int j=0; j<=MAX; ++j){
			if(dp[i-1][j]>0){
				//높은 쪽에 놓은 경우
				if(j+h<=MAX)
				//if(dp[i-1][j] + h <=MAX)
					dp[i][j+h] = max(dp[i][j+h], dp[i-1][j] + h);
				// 낮은 쪽에 놓는데, 새로운 조각을 놓으면 높이 역전하는 경우
				if(h>=j){
					if(h-j<=MAX)
					//if(dp[i-1][j]-j + h <=MAX)
						dp[i][h-j] = max(dp[i][h-j], dp[i-1][j]-j+h);
				}
				else
					dp[i][j-h] = max(dp[i][j-h], dp[i-1][j]);
				// 아무 것도 안 놓는 경우
				dp[i][j] = max(dp[i][j], dp[i-1][j]);      
			}
		}
	}
	if(dp[n][0] == 0) cout << -1;
	else cout << dp[n][0];
	return 0;
}
