#include <algorithm>
#include <stack>
#include <vector>
#include <iostream>
using namespace std;


// 솔루션에 있는 n 풀이 왼쪽을 체크 안해도 되는것은 
// 자신보다 큰 것을 체크하고 왔기 떄문에 당연히 그것보다 작다.
class Solution {
public:
	int maxArea(vector<int>& height) {
		int ret = 0, len = height.size();
		int i = 0, j = len - 1;

		while (i<j)
		{
			int h;
			if (height[i] < height[j]) h = height[i], i++;
			else h = height[j], j--;
			ret = max(ret, h * (j - i + 1));
			
		}
		return ret;
	}
};

int main(void) {
	Solution sol = Solution();
	vector<int> v = { 1,8,6,2,5,4,8,3,7 };
	cout << sol.maxArea(v);
	return 0;
}