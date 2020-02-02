#include <algorithm>
#include <stack>
#include <vector>
#include <iostream>
using namespace std;

// 처음 풀이 높이 작은것 부터 순차적으로 탐색하여
// 제일 왼쪽, 오른쪽 선택
class Solution {
public:
	int maxArea(vector<int>& height) {
		int ret = 0;
		deque<pair<int, int>> dq;
		vector<pair<int, int>> v;
		int hlen = height.size();
		for (int i = 0; i < hlen; ++i) {
			v.push_back({ height[i], i });
			dq.push_back({height[i], i});
		}
		sort(v.begin(), v.end());
		for (int i = 0; i < hlen; ++i) {
			while (!dq.empty() && dq.front().first < v[i].first) {
				dq.pop_front();
			}
			while (!dq.empty() && dq.back().first < v[i].first) {
				dq.pop_back();
			}
			ret = max(ret, (v[i].second - dq.front().second) * v[i].first) ;
			ret = max(ret, (dq.back().second - v[i].second) * v[i].first);
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