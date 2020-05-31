#include <vector>
#include <algorithm>
#include <iostream>
#include <string>
using namespace std;


class Solution {
public:
    // ransoNote의 문자들을 순서 상관없이 다 사용하는 문제
    bool canConstruct(string ransomNote, string magazine) {
        vector<int> rcnt(26, 0);
        vector<int> mcnt(26, 0);      
        for(char &c: ransomNote){
            ++rcnt[c-'a'];
        }   
        for(char &c : magazine){
            ++mcnt[c-'a'];
        }
        for(int i=0; i<26; ++i){
            if(rcnt[i]>mcnt[i]) return false;
        }
        return true;
    }
};