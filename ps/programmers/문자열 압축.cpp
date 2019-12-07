#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int solution(string s) {
	int ret = 0;
	int slen = s.size();
	ret = slen;
	for (int slice = 1; slice <= slen / 2; ++slice)
	{
		int sum = 0;
		int seq = 1;
		string bef = "";
		string cur;
		for (int i = 0; i<slen; i += slice)
		{
			if (i + slice > slen)
			{
				sum += (slen - i);
				if (seq != 1) sum += to_string(seq).size();
				sum += bef.size();
			}
			else
			{
				cur = s.substr(i, slice);
				if (bef == cur)
				{
					++seq;
				}
				else
				{
					if(seq!=1) sum += to_string(seq).size();
					sum += bef.size();
					seq = 1;
					bef = cur;
				}
				if (i == slen - slice)
				{
					if (seq != 1) sum += to_string(seq).size();
					sum += bef.size();
				}
			}
		}
		ret = min(ret, sum);
	}
	return ret;
}


int main(void)
{
	cout << solution("aaaaaaaaaaaaa");

	return 0;
}