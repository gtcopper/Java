package cn.copper.linkedlist;

public class LoopQueue<E> implements Queue<E> {

    private E[] data;
    private int front,tail;
    private int size;

    public LoopQueue(int capacity){
        data = (E[])new Object[capacity+1];//预留一个空闲位置，防止队列为空与队列满时判断条件一致
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue(){
        this(10);
    }

    public int getCapacity(){
        return data.length-1;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public void enqueue(E e) {

        //队列已满
        if((tail+1) % data.length == front){
            resize(2 * getCapacity());
        }
        data[tail] = e;
        tail = (tail+1) % data.length;
        size++;
    }

    @Override
    public E dequeue() {
        if(isEmpty()){
            throw new IllegalArgumentException("队列为空...无法出队");
        }
        E ret = data[front];
        data[front] = null;
        front = (front+1 % data.length);
        size--;
        if(size == getCapacity() / 4 && getCapacity() / 2 != 0)
        {
            resize(getCapacity() / 2);
        }
        return ret;
    }

    @Override
    public E getFront() {
        if(isEmpty()){
            throw new IllegalArgumentException("队列为空...");
        }
        return data[front];
    }
    // 动态数组实现队列扩容
    private void resize(int newCapacity){
        E[] newData = (E[])new Object[newCapacity+1];
        for (int i = 0; i < size; i++) {
                newData[i] = data[(i+front)];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("LoopQueue : size = %d ,capacity = %d\n",size,getCapacity()));
        res.append("front [");
        for (int i = front; i != tail; i = (i+1) % data.length) {
            res.append(data[i]);
            if((i+1) % data.length != tail){
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }
}
