#include <string>
#include <vector>
#include <iostream>
#include <cstring>
#include <algorithm>
using namespace std;



const int ALPHA = 26;

int toIndex(char c) { return (c - 'a'); }

struct Node
{
	Node* child[ALPHA];
	int childCnt;
	Node() : childCnt(0) { memset(child, 0, sizeof(child)); }
	~Node()
	{
		for (int i = 0; i<ALPHA; ++i)
		{
			if (child[ALPHA])
			{
				delete child[i];
			}
		}
	}
	void insert(const char* str)
	{
		if (*str == 0)
		{
			return;
		}
		++childCnt;
		int idx = toIndex(*str);
		if (child[idx] == NULL)
			child[idx] = new Node();
		child[idx]->insert(str + 1);
	}

	void find(const char* str, int* cnt)
	{

		if (*str == '?')
		{
			*cnt += childCnt;
			return;
		}
		if (*str == 0)
		{
			++(*cnt);
			return;
		}
		int idx = toIndex(*str);
		if (child[idx])
			child[idx]->find(str + 1, cnt);
		else
			return;
	}
};


vector<int> solution(vector<string> words, vector<string> queries) {
	int wlen = words.size();
	int qlen = queries.size();
	vector<int> ret(qlen, 0);
	Node* root = new Node[10001];
	Node* reverse_root = new Node[10001];
	for (int i = 0; i<wlen; ++i)
	{
		int len = words[i].size();
		root[len].insert(words[i].c_str());
		reverse(words[i].begin(), words[i].end());
		reverse_root[len].insert(words[i].c_str());
	}
	for (int i = 0; i<qlen; ++i)
	{
		int len = queries[i].size();
		if (queries[i][0] == '?')
		{
			reverse(queries[i].begin(), queries[i].end());
			reverse_root[len].find(queries[i].c_str(), &(ret[i]));
		}
		else
		{
			root[len].find(queries[i].c_str(), &(ret[i]));
		}
	}
	delete[] root;
	delete[] reverse_root;
	return ret;
}

int main(void)
{
	vector<int> v = solution({ "abc","cba" }, { "a??" });
	int vlen = v.size();
	for (int i = 0; i < vlen; ++i)
	{
		cout << v[i] << ' ';
	}
	return 0;
}