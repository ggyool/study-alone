#include <iostream>
using namespace std;

int arr[(int)1e6];
int n;

void swap(int &a, int &b){
    int tmp = a;
    a = b;
    b = tmp;
}

void printArr(){
    for(int i=0; i<n; ++i){
        cout << arr[i] << '\n';
    }
}

void quickSort(int left, int right){
    int pivot = arr[left+(right-left)/2];
    int i = left, j = right;
    // do while 로 안해도 되나 ?
    while(i<=j){
        while(arr[i] < pivot) i++;
        while(arr[j] > pivot) j--;
        if(i<=j){
            swap(arr[i], arr[j]);
            i++, j--;
        }
    }
    if(left<j) quickSort(left, j);
    if(i<right) quickSort(i,right);
}

void mergeSort(int left, int right){
    int mid = left + (right-left)/2;
    if(left<mid)
        mergeSort(left, mid);
    if(mid+1<right)
        mergeSort(mid+1, right);

    int i = left, j = mid + 1;
    int *trr = new int[right-left+1];
    int idx = 0;
    while(i<=mid && j<=right){
        if(arr[i]<=arr[j])
            trr[idx++] = arr[i++];
        else
            trr[idx++] = arr[j++];
    }
    while(i<=mid)
        trr[idx++] = arr[i++];
    while(j<=right)
        trr[idx++] = arr[j++];
    for(int i=0; i<right-left+1;++i){
        arr[i+left] = trr[i];
    }
    delete[] trr;
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n;
    for(int i=0; i<n; ++i){
        cin >> arr[i];
    }
    mergeSort(0, n-1);
    printArr();
    return 0;
}