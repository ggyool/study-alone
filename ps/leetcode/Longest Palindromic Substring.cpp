#include <string>
#include <algorithm>
using namespace std;

class Solution {
public:
	string longestPalindrome(string s) {
		string ret;
		string ss = "*";
		int len = s.size();
		ret = s[0];
		for (int i = 0; i < len; ++i)
		{
			ss += s[i];
			ss += '*';
		}
		int r = 1;
		int center = -1;
		int slen = ss.size();
		for (int i = 2; i < slen - 1; ++i)
		{
			if (r > min(i, slen - 1 - i)) break;
			for (int j = 1; ; ++j)
			{
				if (i - j < 0 || j + j > slen - 1) break;
				if (ss[i - j] != ss[i + j]) break;
				if (r < j)
				{
					r = j;
					center = i;
				}
			}
		}
		if (center == -1) return ret;
		ret = "";
		for (int i = center - r; i <= center + r; ++i)
		{
			if(ss[i] != '*')
				ret += ss[i];
		}
		return ret;
	}
};