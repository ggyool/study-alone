package DesignHashSet;

// 간단하게 %로 hashFunc 만들고 충돌하면 다음 칸을 탐색하며 비어 있는 곳에 저장
// 초기에 key값은 -1로 초기화 되어 있고, 값을 저장하면 key를 넣어주고, data를 true로 바꾼다.
// 삭제하면 그 공간의 key는 그대로 내비두고, data를 false로 바꿈

public class MyHashSet {
    private final int N = 10000;
    Bucket[] bucket;

    public MyHashSet() {
        bucket = new Bucket[N];
        for(int i=0; i<N; ++i){
            bucket[i] = new Bucket();
        }
    }
    public int hashFunc(int key){
        return key%N;
    }
    public void add(int key) {
        int i = hashFunc(key);
        while(bucket[i].key!=-1){
            if(bucket[i].key == key){
                break;
            }
            i = (i + 1) % N;
        }
        bucket[i].data = true;
        bucket[i].key = key;
    }

    public void remove(int key) {
        int i = hashFunc(key);
        while(bucket[i].key!=-1){
            if(bucket[i].key == key){
                bucket[i].data = false;
                break;
            }
            i = (i + 1) % N;
        }
    }
    public boolean contains(int key) {
        int i = hashFunc(key);
        while(bucket[i].key!=-1){
            if(bucket[i].key == key){
                return bucket[i].data;
            }
            i = (i + 1) % N;
        }
        return false;
    }
}

class Bucket{
    int key;
    boolean data;
    Bucket(){
        key = -1;
    }
}
