#include <iostream>
#include <vector>
using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
 };
 
class Solution {
public:
    ListNode* middleNode(ListNode* head) {
        vector<ListNode*> v = {head};
        ListNode* cur = head;
        while(cur->next!=NULL){
            cur = cur->next;
            v.push_back(cur);
        }
        int len = v.size();
        return v[len/2];
    }
};