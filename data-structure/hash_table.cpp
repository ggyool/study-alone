#include <iostream>
#include <cstring>
using namespace std;

#define MAX_KEY 64
#define MAX_DATA 128
#define MAX_TABLE 4096
 
struct Hash{
    char key[MAX_KEY + 1];
    char data[MAX_DATA + 1];
};

Hash tb[MAX_TABLE];
 
unsigned long hashFunc(const char *str)
{
    unsigned long hash = 5381;
    int c;
 
    while (c = *str++)
    {
        hash = (((hash << 5) + hash) + c) % MAX_TABLE;
    }
 
    return hash % MAX_TABLE;
}
 
int find(const char *key, char *data)
{
    unsigned long h = hashFunc(key);
    int cnt = MAX_TABLE;
 
    while (tb[h].key[0] != 0 && cnt--)
    {
        if (strcmp(tb[h].key, key) == 0)
        {
            strcpy(data, tb[h].data);
            return 1;
        }
        h = (h + 1) % MAX_TABLE;
    }
    return 0;
}
 
int add(const char *key, char *data)
{
    unsigned long h = hashFunc(key);
 
    while (tb[h].key[0] != 0)
    {
        if (strcmp(tb[h].key, key) == 0)
        {
            return 0;
        }
 
        h = (h + 1) % MAX_TABLE;
    }
    strcpy(tb[h].key, key);
    strcpy(tb[h].data, data);
    return 1;
}
 
 
int main(int argc, char* argv[])
{
    int N, Q;
	memset(tb, 0, sizeof(tb));
	cin >> N;
	char k[MAX_KEY + 1];
	char d[MAX_DATA + 1];

	for (int i = 0; i < N; i++)
	{
		cin >> k >> d;
		add(k, d);
	}

	cin >> Q;	
	for (int i = 0; i < Q; i++)
	{
		char k[MAX_KEY + 1];
		char d[MAX_DATA + 1];

		cin >> k;
		if (find(k, d))
		{
			cout << d << '\n';
		}
		else
		{
			cout << "not find" << '\n';
		}
	}
    
    return 0;
}