#include <iostream>
#include <queue>
using namespace std;

int k;
int arr[1025];
int len;
queue<int> q;

void traversal(int cur)
{
    if(cur > len) return;
    int left = 2*cur;
    int right = left + 1;
    if(arr[left] == 0) 
        traversal(left);
    arr[cur] = q.front();
    q.pop();
    if(arr[right] == 0) 
        traversal(right);
}

int main(void)
{
    cin >> k;
    int cnt = 1, num;
    for(int i=0; i<k; ++i)
    {
        for(int j=0; j<cnt; ++j)
        {
            cin >> num;
            q.push(num);
        }
        cnt *= 2;
    }
    len = q.size(); // 1~len
    traversal(1);
    cnt = 1;
    int idx = 1;
    for(int i=0; i<k; ++i)
    {
        for(int j=0; j<cnt; ++j)
        {
            cout << arr[idx++] << ' ';
        }
        cout << '\n';
        cnt *= 2;
    }

    return 0;
}