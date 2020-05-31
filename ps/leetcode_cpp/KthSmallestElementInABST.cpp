#include <string>
#include <cstring>
#include <algorithm>
#include <stack>
#include <iostream>
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
    int dp[10001];
    int kthSmallest(TreeNode* root, int k) {
        memset(dp, -1, sizeof(dp));
        dfs(root);
        TreeNode *cur = root;
        while(true){
            int leftCnt = 0, rightCnt = 0;
            if(cur->left!=nullptr)
                leftCnt = dp[cur->left->val];
            if(cur->right!=nullptr)
                rightCnt = dp[cur->right->val];
            if(leftCnt+1==k) break;
            else if(k<=leftCnt) cur = cur->left;
            else {
                cur = cur->right;
                k -= leftCnt+1;
            }
        }
        return cur->val;
    }
    int dfs(TreeNode* cur){
        int &ret = dp[cur->val];
        if(ret!=-1) return ret;
        ret = 1;
        if(cur->left!=nullptr){
            ret += dfs(cur->left);
        }
        if(cur->right!=nullptr){
            ret += dfs(cur->right);
        }
        return ret;
    }
};