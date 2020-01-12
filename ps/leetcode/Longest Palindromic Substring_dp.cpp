#include <string>
#include <iostream>
#include <vector>
#include <cstring>
using namespace std;


class Solution {
public:
	bool dp[1000][1000];
	string longestPalindrome(string s) {
		string ret;
		int maxv = 1;
		int slen = s.size();
		for (int i = 0; i < slen-1; ++i)
		{
			dp[i][i] = true;
			if (s[i] == s[i + 1])
			{
				dp[i][i + 1] = true;
				maxv = 2;
			}
		}
		if (slen!=0) dp[slen - 1][slen - 1] = true;

		for (int i = 3; i <= slen; ++i)
		{
			for (int j = 0; j <= slen - i; ++j)
			{
				dp[j][j+i-1] = dp[j + 1][j + i - 2] && (s[j] == s[j + i - 1]);
				if (dp[j][j + i - 1] && maxv < i)
				{
					maxv = i;
				}
			}
		}

		for (int i = 0; i <= slen-maxv; ++i)
		{
			if (dp[i][i+maxv-1]) {
				return s.substr(i, maxv);
			}
		}
		return "";
	}
};

