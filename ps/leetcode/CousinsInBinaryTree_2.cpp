#include <vector>
#include <iostream>
#include <algorithm>
#include <queue>
using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};



class Solution {
public:
    bool isCousins(TreeNode* root, int x, int y) {
        queue<TreeNode*> q;
        q.push(root);
        int px, py;
        int dx, dy;
        int depth = 1;
        while(!q.empty()){
            // level order traversal?
            int qlen = q.size();
            for(int i=0; i<qlen; ++i){
                TreeNode* cur = q.front();
                q.pop();
                if(cur->left!=nullptr){
                    if(cur->left->val == x) {
                        dx = depth, px=cur->val;
                    }
                    if(cur->left->val == y) {
                        dy = depth, py=cur->val;
                    }
                    q.push(cur->left);
                }
                if(cur->right!=nullptr){
                    if(cur->right->val == x) {
                        dx = depth, px=cur->val;
                    }
                    if(cur->right->val == y) {
                        dy = depth, py=cur->val;
                    }
                    q.push(cur->right);
                }
            }
            ++depth;
        }
        if(dx==dy && px!=py) return true;
        return false;
    }
};


