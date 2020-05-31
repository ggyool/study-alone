#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

struct TreeNode {
    int val;    
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 };
 
class Solution {
public:
    int ans = 0;
    int diameterOfBinaryTree(TreeNode* root) {
        if(root==NULL) return 0;
        int ret = dfs(root);
        return max(ans, ret);
    }
    int dfs(TreeNode* root){
        int ret = 0;
        if(root->left != NULL){
            ret = max(ret, 1 + dfs(root->left));
        }
        if(root->right != NULL){
            int tmp = 1 + dfs(root->right);
            ans = max(ans, ret+tmp);
            ret = max(ret, tmp);
        }
        return ret;
    }
};