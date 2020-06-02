#include <iostream>
using namespace std;

int arr[1000];
int n;

void swap(int &a, int &b){
    int tmp = a;
    a = b;
    b = tmp;
}

// 큰 것 뒤로 보내기
void bubbleSort(){
    for(int i=0; i<n-1; ++i){
        for(int j=1; j<n-i; ++j){
            if(arr[j-1] > arr[j]){
                swap(arr[j-1], arr[j]);
            }
        }
    }
}


// 작은것 하나 고르기 
void selectionSort(){
    for(int i=0; i<n-1; ++i){
        int idx = i;
        for(int j=i+1; j<n; ++j){
            if(arr[idx] > arr[j]){
                idx = j;
            }
        }
        swap(arr[idx], arr[i]);
    }
}

// 구간 늘려나가기
void insertionSort(){
    // i : end
    for(int i = 1; i<n; ++i){
        // 0~i-1 는 sorted state
        int target = arr[i];
        int j;
        // 이전 것을 비교하면 안다.
        for(j=i; j>=1; --j){
            if(arr[j-1] > target) arr[j] = arr[j-1];
            else break;
        }
        // break 한 경우나, 마지막 까지 체크하여 j가 0 인 경우 
        arr[j] = target;
    }
}

void printArr(){
    for(int i=0; i<n; ++i){
        cout << arr[i] << '\n';
    }
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n;
    for(int i=0; i<n; ++i){
        cin >> arr[i];
    }
    insertionSort();
    printArr();
    return 0;
}