#include <algorithm>
#include <vector>
#include <iostream>
using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 };
 
class Solution {
public:
    TreeNode* bstFromPreorder(vector<int>& v) {
        int len = v.size();
        TreeNode* root = new TreeNode(v[0]);
        for(int i=1; i<len; ++i){
            push(root, v[i]);
        }
        return root;
    }


    
    void push(TreeNode* cur, int val){
        if(val < cur->val){
            if(cur->left==NULL){
                TreeNode* newNode = new TreeNode(val);
                cur->left = newNode;
            }
            else{
                push(cur->left, val);
            }
        }
        if(val > cur->val){
            if(cur->right==NULL){
                TreeNode* newNode = new TreeNode(val);
                cur->right = newNode;
            }
            else{
                push(cur->right, val);
            }
        }
    }
};


int main(void){

    Solution *sol = new Solution();
    vector<int> v={8,5,1,7,10,12};
    TreeNode* root = sol->bstFromPreorder(v);
    cout << (root->left)->val;
    
    

    return 0;
}