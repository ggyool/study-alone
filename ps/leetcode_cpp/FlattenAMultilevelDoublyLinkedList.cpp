#include <iostream>
#include <stack>
#include <queue>
#include <map>
#include <unordered_map>
using namespace std;

class Node {
public:
   int val;
   Node* prev;
   Node* next;
   Node* child;
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
		Node *dummy = new Node();
		dummy->next = head;
		chk(head);
		return dummy->next;
   }
};