#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

char arr[8] = {3,3,3,3,3,3,3,3};

void on(int idx){
	cout << idx<< '\n';
}

void solve(){
    for(int i=0; i<8; ++i){
        for(int j=0; j<8; ++j){
            int idx = i*8 + j; 
			if(arr[i] & (1<<(7-j))){
                on(idx);
            }
        }
    }
}

int main(void)
{
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	solve();

	return 0;
}