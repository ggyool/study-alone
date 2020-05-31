#include <string>
#include <cstring>
#include <algorithm>
#include <stack>
#include <vector>
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
        vector<int> v;
        dfs(root, v);
        return v[k-1];
    }
    // inOrder
    void dfs(TreeNode* cur, vector<int> &v){
        if(cur->left!=nullptr){
            dfs(cur->left, v);
        }
        v.push_back(cur->val);
        if(cur->right!=nullptr){
            dfs(cur->right, v);
        }
    }
};