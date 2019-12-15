
struct ListNode {
	int val;
	ListNode *next;
	ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
	public:
		ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
			ListNode* dummyNode = new ListNode(-1);
			ListNode* curNode = dummyNode;
			int remain = 0;
			while (l1 != NULL || l2 != NULL)
			{
				int n1 = l1!=NULL?l1->val:0;
				int n2 = l2!=NULL?l2->val:0;
				int num = n1 + n2 + remain;
				ListNode *newNode = new ListNode(num%10);
				remain = num / 10;
				curNode->next = newNode;
				curNode = newNode;
				if (l1 != NULL) l1 = l1->next;
				if (l2!= NULL) l2 = l2->next;
			}
			if (remain)
			{
				ListNode *newNode = new ListNode(1);
				curNode->next = newNode;
				curNode = newNode;
			}
			return dummyNode->next;
		}
};