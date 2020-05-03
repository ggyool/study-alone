#include <vector>
#include <algorithm>
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
    int ans; 
    int maxPathSum(TreeNode* root) {
        ans = -987654321;
        dfs(root);
        return ans;
    }
    int dfs(TreeNode *cur){
        int leftV = 0, rightV = 0;
        if(cur->left != NULL){
            leftV = dfs(cur->left);
        }
        if(cur->right != NULL){
            rightV = dfs(cur->right);
        }
        int val = cur->val;
        int ret = val;
        ret = max(ret, val+leftV);
        ret = max(ret, val+rightV); 
        ans = max(ans, val);
        ans = max(ans, val+leftV);
        ans = max(ans, val+rightV);
        ans = max(ans, val+leftV+rightV);
        return ret;
    }
};