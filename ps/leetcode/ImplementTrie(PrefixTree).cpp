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
        if(word.size()==0) {
            this->isTerminal = true;
            return;
        }
        int idx = word[0] - 'a';
        if(this->child[idx] == NULL){
            Trie *newNode = new Trie();
            this->child[idx] = newNode;
        }
        this->child[idx]->insert(word.substr(1));
    }
    
    /** Returns if the word is in the trie. */
    bool search(string word) {
        if(word.size()==0) {
            if(this->isTerminal)
                return true;
            else
                return false;
        }
        int idx = word[0] - 'a';
        if(this->child[idx] == NULL){
            return false;
        }
        else{
            return this->child[idx]->search(word.substr(1));
        }
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    bool startsWith(string prefix) {
        if(prefix.size()==0) return true;
        int idx = prefix[0] - 'a';
        if(this->child[idx] == NULL){
            return false;
        }
        else{
            return this->child[idx]->startsWith(prefix.substr(1));
        }
    }
};
