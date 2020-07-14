#include <string>
#include <cstring>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

// 2020-05-09 다시풀어봄
struct Node{
    Node* child[26];
    int childCnt;
    Node(){
        memset(child, 0, sizeof(child));
        childCnt = 0;
    }
};

struct dijkstra{
    Node* root;
    dijkstra(){
        root = new Node();
    }
    void insert(const char* s, Node* curNode=NULL){
        if(*s==0) return;
        if(curNode==NULL) curNode = root;
        ++(curNode->childCnt);
        int idx = toIndex(*s);
        if(curNode->child[idx] == NULL){
            curNode->child[idx] = new Node();
        }
        insert(s+1, curNode->child[idx]);
    }
    int toIndex(const char &c){
        return c-'a';
    }
    int find(const char* s, Node* curNode=NULL){
        if(*s==0) return 1;
        if(curNode==NULL) curNode = root;
        if(*s=='?') return curNode->childCnt;
        int idx = toIndex(*s);
        if(curNode->child[idx]==NULL) return 0;
        return find(s+1, curNode->child[idx]);
    }
};

vector<int> solution(vector<string> words, vector<string> queries) {
    dijkstra dijkstras[10001];
    dijkstra rdijkstras[10001];
    int wlen = words.size();
    for(int i=0; i<wlen; ++i){
        int slen = words[i].size();
        dijkstras[slen].insert(words[i].c_str());
        reverse(words[i].begin(), words[i].end());
        rdijkstras[slen].insert(words[i].c_str());
    }
    vector<int> ret;
    int qlen = queries.size();
    for(int i=0; i<qlen; ++i){
        int slen = queries[i].size();
        if(queries[i][0]!='?'){
            ret.push_back(dijkstras[slen].find(queries[i].c_str()));
        }
        else{
            reverse(queries[i].begin(), queries[i].end());
            ret.push_back(rdijkstras[slen].find(queries[i].c_str()));
        }   
    }
    return ret;
}


int main(void){
    vector<string> va = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
    vector<string> vb ={"fro??", "????o", "fr???", "fro???", "pro?"};
    vector<int> ret = solution(va,vb);
    for(int i=0; i<ret.size(); ++i){
        cout << ret[i] << '\n';
    }
    return 0;
}


	