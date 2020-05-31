#include <algorithm>
#include <vector>
#include <iostream>
using namespace std;

typedef long long lld;

class Solution {
// 제약이 안나와있어 초기화가 애매
// 해당 항을 포함하는 가장 큰 양수 maxv, 가장 작은 음수 minv
// 다음 항이 음수이면 minv * v[i] 는 maxv 가 된다.
public:
	lld maxProduct(vector<int>& v) {
		lld ret = v[0];
		lld vlen = v.size();
		vector<lld> minv(vlen, 0);
		vector<lld> maxv(vlen, 0);
		if (v[0] < 0) minv[0] = v[0], maxv[0] = 0;
		else if (v[0] > 0) minv[0] = 0, maxv[0] = v[0];
		else  minv[0] = 0, maxv[0] = 0;
		for (lld i = 1; i < vlen; ++i) {
			if (v[i] < 0) {
				maxv[i] = minv[i - 1] * v[i];
				minv[i] = min((lld)v[i], maxv[i - 1] * v[i]);
				ret = max((lld)ret, minv[i]);
				ret = max((lld)ret, maxv[i]);
			}
			else if (v[i] > 0) {
				maxv[i] = max((lld)v[i], maxv[i - 1] * v[i]);
				minv[i] = minv[i - 1] * v[i];
				ret = max((lld)ret, minv[i]);
				ret = max((lld)ret, maxv[i]);
			}
			else {
				maxv[i] = 0;
				minv[i] = 0;
				ret = max(ret, (lld)0);
			}
		}
		return ret;
	}
};

