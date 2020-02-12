#include <vector>
#include <algorithm>
#include <unordered_map>
#include <stack>
using namespace std;

// hash 도 해봤는데 이분탐색보다 느림
// 2n 인듯 
class Solution {
public:
	vector<int> twoSum(vector<int>& nums, int target) {
		int len = nums.size();
		vector<int> ret;
		unordered_map<int, stack<int>> mp;
		for (int i = 0; i < len; ++i) {
			mp[nums[i]].push(i);
		}
		for (int i = 0; i < len; ++i) {
			int findTarget = target - nums[i];
			if (findTarget == nums[i]) {
				if (mp[findTarget].size() >= 2) {
					stack<int> &stk = mp[findTarget];
					ret.push_back(stk.top()); 
					stk.pop();
					ret.push_back(stk.top());
					stk.pop();
					break;
				}	
			}
			else {
				if (mp[nums[i]].size() >= 1 && mp[findTarget].size() >= 1) {
					ret.push_back(mp[nums[i]].top());
					ret.push_back(mp[findTarget].top());
					break;
				}
			}
		}
		return ret;
	}
};