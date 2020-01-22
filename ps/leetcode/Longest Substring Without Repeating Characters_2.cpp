#include <string>
#include <unordered_map>
#include <algorithm>
#include <iostream>
using namespace std;

// 처음 풀었던게 2n, 이게 n인 것 같은데 시간은 그게 그거

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