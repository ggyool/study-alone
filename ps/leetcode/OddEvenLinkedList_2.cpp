#include <iostream>
#include <vector>
#include <queue>
#include <stack>
#include <algorithm>
using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

// java 코드처럼 깔끔하게 하고 싶었는데
class Solution {
public:
    ListNode* oddEvenList(ListNode* head) {
        if(head==nullptr) return head;
        ListNode *cur = head;
        ListNode *even=nullptr, *evenHead = cur->next;
        while(cur->next != nullptr){
            if(even==nullptr) {
                even = cur->next;
            }
            else{
                even->next = cur->next;
                even = cur->next;
            }
            if(even==nullptr || even->next == nullptr) break;
            cur->next = even->next;
            cur = even->next;
        }
        if(even!=nullptr) even->next = nullptr;
        cur->next = evenHead;
        return head;
    }
};