#include <iostream>
#include <stack>
#include <queue>
#include <map>
#include <unordered_map>
using namespace std;

// Definition for a Node.
class Node {
public:
   int val;
   Node* prev;
   Node* next;
   Node* child;
   Node(int val) :val(val) {}
   Node(int val, Node* _prev) :val(val), prev(_prev) {}
   Node(int val, Node* _prev, Node* _next) :val(val), prev(_prev) , next(_next) {}
   Node(int val, Node* _prev, Node* _next, Node* _child) :val(val), prev(_prev), next(_next), child(_child) {}
};


class Solution {
public:
	// tail 노드를 return
	Node* chk(Node *iter) {
		if (iter->child) {
			Node *add = iter->next; // 4
			iter->child->prev = iter; // 7->3
			iter->next = iter->child; // 3->7
			iter->child = NULL;

			Node *tail = chk(iter->next); // chk(7) = 10
			if(add!=NULL){
				tail->next = add;
				add->prev = tail;
				return chk(add);
			}
			return tail;
		}
		else{
			if(iter->next==NULL) return iter;
			return chk(iter->next);
		}
	}

   Node* flatten(Node* head) {
	   	if(head==NULL) return NULL;
		Node *dummy = new Node(0);
		dummy->next = head;
		chk(head);
		return dummy->next;
   }
};
int main() {
   Solution sol = Solution();
   Node *l1 = new Node(1);
   l1->next = new Node(2, l1);
   l1->next->next = new Node(3, l1->next);
   l1->next->next->next = new Node(4, l1->next->next);
   l1->next->next->next->next = new Node(5, l1->next->next->next);
   l1->next->next->next->next->next = new Node(6, l1->next->next->next->next);


   Node *l2 = new Node(7);
   l2->next = new Node(8);
   l2->next->next = new Node(9);
   l2->next->next->next = new Node(10);
   
   l1->next->next->child = l2;

   sol.flatten(l1);
}