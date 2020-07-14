#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
#include <unordered_map>
using namespace std;

unordered_map<long long, long long> mp;

long long find(long long target){
    if(mp[target]==0){
        return mp[target]=target;
    }
    else{
        if(mp[target]==target){
            return mp[target] = find(target+1);
        }
        else{
            return mp[target] = find(mp[target]);
        }
    }
}

vector<long long> solution(long long k, vector<long long> room_number) {   
    vector<long long> ret;
    int len = room_number.size();
    for(int i=0; i<len; ++i){
        long long target = room_number[i];
        long long idx = find(target);
        ret.push_back(idx);
    }
    return ret;
}


int main(void){
    vector<long long> v = {2,3,2,4,1};
    vector<long long> ret = solution(10, v);
    for(int i=0; i<(int)ret.size(); ++i){
        cout << ret[i] << ' ';
    }
        
    
    return 0;
}
