package DesignCircularQueue;

public class MyCircularQueue {

    int[] arr;
    int head, tail, size, cnt;
    // enqueue는 tail++ 후 넣고
    // dequeue는 빼고 head++
    public MyCircularQueue(int k) {
        size = k;
        arr = new int[k];
        head = 0;
        tail = -1;
        cnt = 0;
    }

    public boolean enQueue(int value) {
        if(isFull()) return false;
        tail = (tail + 1) % size;
        arr[tail] = value;
        ++cnt;
        return true;
    }

    public boolean deQueue() {
        if(isEmpty()) return false;
        head = (head + 1) % size;
        --cnt;
        return true;
    }

    public int Front() {
        if(isEmpty()) return -1;
        return arr[head];
    }

    public int Rear() {
        if(isEmpty()) return -1;
        return arr[tail];
    }

    public boolean isEmpty() {
        if(cnt==0) return true;
        return false;
    }

    public boolean isFull() {
        if(cnt==size) return true;
        return false;
    }
}
