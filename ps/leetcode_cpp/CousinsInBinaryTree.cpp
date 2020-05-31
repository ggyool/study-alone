#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};

struct Info{
    bool isFind;
    int depth, parent;
    Info(){
        isFind = false;
        depth = 0;
        parent = -1;
    }
    Info(bool tf, int d, int p){
        isFind = tf;
        depth = d;
        parent = p;
    }
    int getDepth(){
        return depth;
    }
    int getParent(){
        return parent;
    }
};

class Solution {
public:
    
    Info findDepth(TreeNode* cur, int val){
        if(cur->val == val){
            return Info(true, 0,-1);
        }
        if(cur->left!=nullptr){
            Info res = findDepth(cur->left, val);
            if(res.isFind == true){
                if(res.getDepth() == 0){
                    res.parent = cur->val;
                }
                ++res.depth;
                return res;
            }
        }
        if(cur->right!=nullptr){
            Info res = findDepth(cur->right, val);
            if(res.isFind == true){
                if(res.getDepth() == 0){
                    res.parent = cur->val;
                }
                ++res.depth;
                return res;
            }
        }
        return Info();
    }
    bool isCousins(TreeNode* root, int x, int y) {
        Info xres = findDepth(root, x);
        Info yres = findDepth(root, y);
        if(xres.getDepth() == yres.getDepth()){
            if(xres.getParent() != yres.getParent()){
                return true;
            }
        }
        return false;
    }
};

