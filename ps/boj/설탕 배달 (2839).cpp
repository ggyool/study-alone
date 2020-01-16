#include <iostream>
using namespace std;

int main(void) {
	int n;
	cin >> n;
	bool isAble = false;
	int maxFive = n / 5;
	int i;
	for(i=maxFive; i>=0; --i)
	{
		if ((n - 5 * i) % 3 == 0) break;
	}
	if (i >= 0) cout << i + ((n - 5 * i)/3);
	else cout << -1;

	return 0;
}