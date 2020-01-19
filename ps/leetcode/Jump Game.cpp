
#include <vector>
#include <algorithm>
using namespace std;

class Solution {
public:
	int len;
	bool canJump(vector<int>& v) {
		len = v.size();
		int maxv = 0;
		for (int i = 0; i < len-1; ++i)
		{
			if(maxv>=i)
				maxv = max(maxv, i + v[i]);
		}
		return maxv >= len - 1;
	}
};
