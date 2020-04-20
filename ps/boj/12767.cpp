#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <cstring>
#include <unordered_set>
using namespace std;

struct Node{
    Node *left, *right;
    int val;
    Node(int _val = 0){
        left = right = NULL;
        val = _val;
    }
};

void add(Node* cur, Node* &newNode){
    if(cur->val < newNode->val){
        if(cur->right==NULL){
            cur->right = newNode;
        }
        else{
            add(cur->right, newNode);
        }
    }
    else{
        if(cur->left==NULL){
            cur->left = newNode;
        }
        else{
            add(cur->left, newNode);
        }
    }
}

string preOrder(Node* cur){
    string ret = "c";
    if(cur->left!=NULL) {
        ret += 'l';
        ret += preOrder(cur->left);
        ret += 'L';
    }
    if(cur->right!=NULL) {
        ret += 'r';
        ret += preOrder(cur->right);
        ret += 'R';
    }
    return ret;
}

void remove(Node* cur){
    if(cur->left!=NULL) remove(cur->left);
    if(cur->right!=NULL) remove(cur->right);
    delete cur;
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    unordered_set<string> st;
    int n,m;
    cin >> n >> m;
    for(int i=0; i<n; ++i){
        Node* root = new Node();
        for(int j=0; j<m; ++j){
            int x;
            cin >> x;
            if(j==0){
                root->val = x;
            }
            else{
                Node* newNode = new Node(x);
                add(root, newNode);
            }
        }
        string res = preOrder(root);
        auto it = st.find(res);
        if(it == st.end()){
            st.insert(res);
        }
        remove(root);
    }
    cout << st.size();
    return 0;
}


