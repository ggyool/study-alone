#include <algorithm>
#include <iostream>
#include <string>
using namespace std;

class Solution {
public:
	bool isPalindrome(int x) {
		if (x < 0) return false;
		string s = to_string(x);
		int slen = s.size();
		for (int i = 0; ; ++i) {
			int left = i;
			int right = slen - 1 - i;
			if (left >= right) break;
			if (s[left] != s[right]) return false;;
		}
		return true;
	}
};

int main(void) {
	Solution sol = Solution();
	cout << sol.isPalindrome(1101);
	return 0;
}