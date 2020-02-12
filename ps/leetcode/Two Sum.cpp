#include <vector>
#include <algorithm>
using namespace std;

// 처음 - 정렬후 2분탐색 2nlogn 인듯
class Solution {
public:
	int findPair(vector<pair<int,int>> &pv, int left, int right, int target) {
		int	mid = -1;
		while (left <= right) {
			mid = left + (right - left) / 2;
			if (pv[mid].first == target) return pv[mid].second;
			else if(pv[mid].first > target){
				return findPair(pv, left, mid - 1, target);
			}
			else {
				return findPair(pv, mid+1, right, target);
			}
		}
		return mid;
	}

	vector<int> twoSum(vector<int>& nums, int target) {
		vector<pair<int, int>> pv;
		int len = nums.size();
		for (int i = 0; i < len; ++i) {
			pv.push_back({nums[i], i});
		}
		sort(pv.begin(), pv.end());
		
		for (int i = 0; i < len; ++i) {
			int findNumber = target - pv[i].first;
			int findIndex = -1;
			if (findNumber < pv[i].first) {
				findIndex = findPair(pv, 0, i-1, findNumber);
			}
			else {
				findIndex = findPair(pv, i+1, len-1, findNumber);
			}
			if (findIndex != -1)
				return {pv[i].second, findIndex};
		}
		return {};
	}
};