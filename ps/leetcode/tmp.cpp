#include <iostream>
using namespace std;

class AB{
    int a,b;
public:
    AB(){}
    AB(int a, int b) : a(a), b(b){
        // this->a = a;
        // this->b = b;
    }
    void func(){

    }
};

int main(void){
    
    AB *ab = new AB(10, 20);
    delete ab;


    AB abab = AB(10, 20);
    abab.func();

}




