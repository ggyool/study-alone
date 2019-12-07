#include <string>
#include <vector>
#include <iostream>
#include <stack>
using namespace std;


string s;
int slen;

string devide(int left, int right)
{
	if (left >= right) return "";
	int leftCnt = 0;
	int rightCnt = 0;
	stack<char> stk;
	int i;
	for (i = left; i <= right; ++i)
	{
		char c = s[i];
		if (c == '(') ++leftCnt;
		else if (c == ')') ++rightCnt;
		if(stk.empty() || c=='(') stk.push(c);
		else if(stk.top() == '(') stk.pop();
		if (leftCnt == rightCnt) break;
	}
	string ret;
	string v = devide(i + 1, right);
	if (stk.empty())
	{
		ret = s.substr(left, i - left + 1) + v;
		return ret;
	}
	else
	{
		ret = '(' + v + ')';
		for (int j = left + 1; j <= i - 1; ++j)
		{
			if (s[j] == '(') ret += ')';
			else ret += '(';
		}
		return ret;
	}
}

string solution(string p) {
	string ret = "";
	s = p;
	slen = s.size();

	ret = devide(0, slen - 1);

	return ret;
}

int main(void)
{
	cout << solution("))((()");

	return 0;
}