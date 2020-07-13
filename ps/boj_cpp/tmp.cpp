#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    // [1,0,2,3,0,4,5,0]
    void duplicateZeros(vector<int>& arr) {
        int len = arr.size();
        int cnt = 0;
        int end = 0;
        for(int i=0; i<len; ++i){
            if(arr[i]==0) cnt += 2;
            else ++cnt;
            if(cnt>=len) {
                end = i;
                break;
            }
        }
        // cnt > len 마지막이 0이라서
        // cnt == len 마지막이 숫자라서

        int j = len - 1;
        if(cnt>len) {
            arr[j--] = 0;
            --end;
        }
        for(int i=end; i>=0; --i){
            if(arr[i]==0){
                arr[j--] = 0;
                arr[j--] = 0;
            }
            else{
                arr[j--] = arr[i];
            }
        }
    }
};

void makeTree(int *arr, int len){
    Node *dummy = new Node();
    Node *cur = dummy;
    for(int i=0; i<len; ++i){
        Node *newNode = new Node();
        newNode->val = arr[i];
        cur->next = newNode;
        cur = newNode;
    }
    return dummy->next;
}

int main(void){
    int arr[10] = {1,2,3,4,5,6,7,8,9,10};

    makeTree(arr, 10);
    return 0;
}