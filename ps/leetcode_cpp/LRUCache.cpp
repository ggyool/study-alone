#include <queue>
#include <unordered_map>
#include <iostream>
using namespace std;

class LRUCache {
public:
    queue<int> q;
    unordered_map<int, int> valueMp;
    unordered_map<int, int> countMp;
    int maxSize;
    int size;
    LRUCache(int capacity) {
        size = 0;
        maxSize = capacity;
    }
    bool isExist(int key){
        auto it = countMp.find(key);
        if(it != countMp.end()){
            return true;
        }
        return false;
    }

    int get(int key) {
        if(isExist(key)){
            q.push(key);
            ++countMp[key];
            return valueMp.find(key)->second;
        }
        return  -1;
    }
    
    bool pop(int key){
        --countMp[key];
        if(countMp[key]==0){
            countMp.erase(key);
            valueMp.erase(key);
            
            return true;
        }
        return false;
    }

    void put(int key, int value) {
        while(size>=maxSize){
            if(isExist(key)) break;
            int targetKey = q.front();
            q.pop();
            if(pop(targetKey)) {
                --size;
            }
        }
        q.push(key);
        if(!isExist(key)){
            ++size;   
        }
        ++countMp[key];
        valueMp[key] = value;
    }
};


int main(void){

    LRUCache cache(2);
    cache.put(1,1);
    cache.put(2,2);
    cout << cache.get(1) << '\n';
    cache.put(3,3);
    cout << cache.get(2)<< '\n';
    cache.put(4,4);
    cout << cache.get(1)<< '\n';
    cout << cache.get(3)<< '\n';
    cout << cache.get(4)<< '\n';
    return 0;
}