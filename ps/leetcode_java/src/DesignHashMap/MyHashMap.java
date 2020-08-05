package DesignHashMap;

public class MyHashMap {

    private final int N = 10000;
    Bucket[] bucket;
    public MyHashMap() {
        bucket = new Bucket[N];
        for(int i=0; i<N; ++i){
            bucket[i] = new Bucket();
        }
    }
    public int hashFunc(int key){
        return key%N;
    }
    public void put(int key, int value) {
        int i = hashFunc(key);
        while(bucket[i].key!=-1){
            if(bucket[i].key == key){
                break;
            }
            i = (i + 1) % N;
        }
        bucket[i].data = value;
        bucket[i].key = key;
    }

    public int get(int key) {
        int i = hashFunc(key);
        while(bucket[i].key!=-1){
            if(bucket[i].key == key){
                return bucket[i].data;
            }
            i = (i + 1) % N;
        }
        return -1;
    }

    public void remove(int key) {
        int i = hashFunc(key);
        while(bucket[i].key!=-1){
            if(bucket[i].key == key){
                bucket[i].data = -1;
                break;
            }
            i = (i + 1) % N;
        }
    }
}

class Bucket{
    int key, data;
    Bucket(){
        this.key = -1;
    }
}
