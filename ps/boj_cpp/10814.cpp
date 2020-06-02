#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
using namespace std;

struct Member{
    int age;
    string name;
    Member(int age, string name) : age(age), name(name){}
    bool operator<(const Member &ref) const{ 
        return age<ref.age;
    }  
};

vector<Member> v;
int n;

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n;
    for(int i=0; i<n; ++i){
        int age;
        string name;
        cin >> age >> name;
        v.push_back(Member(age,name));
    }
    stable_sort(v.begin(), v.end());
    for(int i=0; i<n; ++i){
        cout << v[i].age << ' ' << v[i].name << '\n';
    }
    return 0;
}
