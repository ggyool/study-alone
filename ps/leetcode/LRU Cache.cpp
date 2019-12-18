#include <unordered_map>
#include <queue>
using namespace std;

class LRUCache {
	int cap;
	int cnt;
	unordered_map<int, int> valueMap;
	unordered_map<int, int> cntMap;
	queue<int> q;

public:
	LRUCache(int capacity) {
		cap = capacity;
		cnt = 0;
	}

	int get(int key) {
		if (cntMap[key] == 0) return -1;
		++cntMap[key];
		q.push(key);
		return valueMap[key];
	}

	void put(int key, int value) {
		while (cap == cnt)
		{
			if (cntMap[key] > 0) break;
			int tkey = q.front();
			if (cntMap[tkey] == 1) --cnt;
			--cntMap[tkey];
			q.pop();
		}
		valueMap[key] = value;
		++cntMap[key];
		q.push(key);
		if (cntMap[key] == 1) ++cnt;
	}
};

/**
* Your LRUCache object will be instantiated and called as such:
* LRUCache* obj = new LRUCache(capacity);
* int param_1 = obj->get(key);
* obj->put(key,value);
*/