#include <cstring>
#include <iostream>
using namespace std;


// referred to Algorithm Problem Solving Strategies

const int ALPHABETS = 26;

int toIdx(char c)
{
    return c - 'A';
}

struct Node
{
    Node* childlen[ALPHABETS];
    // 이 노드가 종료 노드인가? (단어의 끝)
    bool terminal;
    Node() : terminal(false)
    {
        memset(childlen, false, sizeof(childlen));
    }
    ~Node()
    {
        for(int i=0; i<ALPHABETS; ++i)
        {
            if(childlen[i]) delete childlen[i];
        }
    }
    // 이 노드를 루트로 하는 트라이에 문자열 Key를 추가한다.
    void insert(const char* key)
    {
        if(*key == 0) terminal = true;
        else
        {
            int next = toIdx(*key);
            if(childlen[next] == NULL) 
                childlen[next] = new Node();
            childlen[next]->insert(key + 1);
        }
    }
    
    // 문자열 key와 대응되는 노드를 찾는다. 없으면 NULL
    Node* find(const char *key)
    {
        if(*key==0) return this;
        int next = toIdx(*key);
        if(childlen[next] == NULL) return NULL;
        return childlen[next]->find(key + 1);
    }
};

int main(void)
{
	Node root = Node();
	root.insert("ABC");
    //AB를 넣지 않았지만 find에는 구현되어있지 않다.
    cout << root.find("ABC"); // 주소값
    cout << root.find("AB"); // 주소값
    cout << root.find("AC"); // NULL
	
    if(root.find("~~~"))
    {
        if(root.find("~~~")->terminal == true)
        {
            "있다!";
        }
    }
	return 0;
}