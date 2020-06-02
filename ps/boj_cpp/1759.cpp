#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <cstring>
using namespace std;

int l,c;
char arr[15];
bool isVowel[26];
string s;

void pick(int idx, int parent, int son){
    if(parent+son == l){
        if(parent>=1 && son>=2)
            cout << s << '\n';
        return;
    }
    else if(parent+son > l) return;
    if(idx>=c) return;
    char ch = arr[idx];
    s.push_back(ch);
    pick(idx+1, parent+isVowel[ch-'a'], son+!isVowel[ch-'a']);
    s.pop_back();

    pick(idx+1, parent, son);

}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    isVowel['a'-'a'] = true;
    isVowel['e'-'a'] = true;
    isVowel['i'-'a'] = true;
    isVowel['o'-'a'] = true;
    isVowel['u'-'a'] = true;
    cin >> l >> c;
    for(int i=0; i<c; ++i){
        cin >> arr[i];
    }
    sort(arr, arr+c);
    pick(0, 0, 0);
    return 0;
}

