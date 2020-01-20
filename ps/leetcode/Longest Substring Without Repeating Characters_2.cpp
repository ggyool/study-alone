#include <string>
#include <unordered_map>
#include <algorithm>
#include <iostream>
using namespace std;

// n 
// mp.count 썼었는데 o(1) 이 아닌가봄 처음 풀었던 2n이랑 비슷해서 빼버리고
// 기본값 0을 사용하기 위해 1더해서 넣었다.

class Solution {
public:
	int lengthOfLongestSubstring(string s) {
		int ret = 0;
		int slen = s.size();
		int start = 1;
		unordered_map<char, int> mp;
		for (int i = 0; i < slen; ++i) 
		{
			char c = s[i];
			if (mp[c]<start)
			{
				mp[c] = i + 1;
			}
			else
			{
				ret = max(ret, i + 1 - start);
				start = mp[c] + 1;
				mp[c] = i + 1;
			}
		}
		ret = max(ret, slen + 1 - start);
		return ret;
	}
};

int main(void)
{
	string s = "abcabcb";
	Solution obj = Solution();
	obj.lengthOfLongestSubstring(s);
	return 0;
}