#include <iostream>
#include <vector>
#include <queue>
#include <stack>
#include <algorithm>
using namespace std;


class Trie {
public:
    Trie* child[26];
    bool isTerminal;
    /** Initialize your data structure here. */
    Trie() {
        for(int i=0; i<26; ++i) child[i] = NULL;
        isTerminal = false;
    }
    
    /** Inserts a word into the trie. */
    void insert(string word) {
        Trie *cur = this;
        int len = word.size();
        for(int i=0; i<len; ++i){
            int idx = word[i] - 'a';
            if(cur->child[idx] == NULL){
                cur->child[idx] = new Trie();
            }
            cur = cur->child[idx];
        }
        cur->isTerminal = true;
    }
    
    /** Returns if the word is in the trie. */
    bool search(string word) {
        Trie *cur = this;
        int len = word.size();
        for(int i=0; i<len; ++i){
            int idx = word[i] - 'a';
            if(cur->child[idx] == NULL) {
                return false;
            }
            else{
                cur = cur->child[idx];
            }
        }
        return cur->isTerminal;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    bool startsWith(string prefix) {
        Trie *cur = this;
        int len = prefix.size();
        for(int i=0; i<len; ++i){
            int idx = prefix[i] - 'a';
            if(cur->child[idx] == NULL) {
                return false;
            }
            else{
                cur = cur->child[idx];
            }
        }
        return true;
    }
};
