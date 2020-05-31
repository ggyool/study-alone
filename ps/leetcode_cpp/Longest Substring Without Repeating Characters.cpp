#include <string>
#include <unordered_map>
#include <queue>
#include <vector>
#include <algorithm>
using namespace std;


class Solution {
public:
	int lengthOfLongestSubstring(string s) {
		queue<char> q;
		int slen = s.size();	
		unordered_map<char, bool> mp;
		int ret = 0;
		for (int i = 0; i < slen; ++i)
		{
			char c = s[i];
			if (mp[c] == false) {
				mp[c] = true;
				q.push(c);
			}
			else 
			{
				ret = max(ret, (int)q.size());
				while (!q.empty())
				{
					char cpop = q.front();
					q.pop();
					mp[cpop] = false;
					if (cpop == c)
					{
						q.push(c);
						mp[c] = true;
						break;
					}
				}
			}
		}
		ret = max(ret, (int)q.size());
		return ret;
	}
};