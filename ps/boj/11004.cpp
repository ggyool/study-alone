#include <algorithm>
#include <iostream>
#include <vector>
using namespace std;

// 필요한 범위만 quick
int n,k;
vector<int> v;

void quickSort(int left, int right){
    int pivot = v[left+(right-left)/2];
    int i = left, j = right;
    int tmp;
    while(i<=j){
        while(v[i] < pivot) ++i;
        while(v[j] > pivot) --j;
        if(i<=j){
            tmp = v[i];
            v[i] = v[j];
            v[j] = tmp;
            i++;
            j--;
        }
    }
    if(left<j && k-1<=j) quickSort(left, j);
    if(i<right && k-1>=i) quickSort(i, right);
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n >> k;
    int num;
    for(int i=0; i<n; ++i){
        cin >> num;
        v.push_back(num);
    }
    quickSort(0, n-1);
    cout << v[k-1];
    return 0;
}