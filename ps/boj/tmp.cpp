#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main(void)
{
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	vector<int> v = {0,1,1};
	do{
		for(int i=0; i<3; ++i){
			cout << v[i] << ' ';
		}
		cout << '\n';
	}while(next_permutation(v.begin(), v.end()));



	return 0;
}