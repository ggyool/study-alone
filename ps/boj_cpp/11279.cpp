#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <cstring>
using namespace std;


class Heap{
public:
    int arr[100002];
    int size;
    Heap(){
        memset(arr, 0, sizeof(arr));
        size = 0;
    }
    void push(int val){
        ++size;
        int i = size;
        while(i>1){
            int pi = i/2;
            int pv = arr[pi];
            if(pv<val){
                arr[i] = pv;
            }
            else{
                arr[i] = val;
                break;
            }
            i/=2;
        }
        if(i==1) arr[1] = val;
    }
    int top(){
        return arr[1];
    }
    int pop(){
        if(size==0) return 0;
        int ret = arr[1];
        int val = arr[size];
        arr[size] = 0;
        size--;
        int i = 1;
        while(2*i<=size){
            int li = 2*i;
            int ri = 2*i + 1; // 없는 idx 여도 0이 들어가 있다.
            int lv = arr[li];
            int rv = arr[ri];
            bool leftIsBig = false;
            if(lv>=rv) leftIsBig = true;
            if(val<lv && val<rv){
                if(leftIsBig){
                    arr[i] = lv;
                    i = li;
                }
                else{
                    arr[i] = rv;
                    i = ri;
                }
            }
            else if(val < lv){
                arr[i] = lv;
                i = li;
            }
            else if(val < rv){
                arr[i] = rv;
                i = ri;
            }
            else{
                arr[i] = val;
                break;
            }
        }
        arr[i] = val;
        return ret;
    }
    
};


int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    Heap heap;
    int n;
    cin >> n;
    for(int i=0; i<n; ++i){
        int x;
        cin >> x;
        if(x==0) cout << heap.pop() << '\n';
        else heap.push(x);
    }
    return 0;
}

