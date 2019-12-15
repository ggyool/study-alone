#include <unordered_map>
#include <set>
#include <algorithm>
#include <deque>
using namespace std;
	
class LRUCache {
	int cap;
	int total;
	deque<int> dq;
	unordered_map<int, int> valueMap;
	unordered_map<int, int> countMap;
public:
	LRUCache(int capacity) {
		cap = capacity;
		total = 0;
	}
	int get(int key) {
		if (countMap[key] > 0)
		{
			dq.push_back(key);
			++countMap[key];
			return valueMap[key];
		}
		return -1;
	}
	void put(int key, int value) {
		while (cap!=0 && total==cap)
		{
			if (countMap[key] > 0) break;
			if (countMap[dq.front()] > 1)
			{
				--countMap[dq.front()];
				dq.pop_front();
				continue;
			}
			int eraseKey = dq.front();
			--countMap[eraseKey];
			--total;
			dq.pop_front();
		}
		dq.push_back(key);
		valueMap[key] = value;
		if (countMap[key] == 0) ++total;
		++countMap[key];		
	}
};
