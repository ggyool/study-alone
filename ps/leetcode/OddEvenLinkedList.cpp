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

class Solution {
public:
    ListNode* oddEvenList(ListNode* head) {
        ListNode* odd=nullptr, *even=nullptr;
        ListNode *next=nullptr, *evenHead=nullptr;
        ListNode *cur = head;
        if(head==nullptr) return head;
        int i=0;
        while(cur != nullptr){
            next = cur->next;
            ++i;
            if(i&1){
                if(odd==nullptr) {
                    odd = cur;
                    odd->next = nullptr;
                }
                else{
                    odd->next=cur;
                    odd = cur;
                    odd->next = nullptr;
                }
            }
            else{
                if(even==nullptr) {
                    even = cur;
                    evenHead = even;
                    even->next = nullptr;
                }
                else{
                    even->next=cur;
                    even = cur;
                    even->next = nullptr;
                }
            }
            cur = next;
        }
        odd->next = evenHead;
        return head;
    }
};