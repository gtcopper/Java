package cn.copper.queue;

public interface Queue<E> {

    //队列的大小
    int getSize();
    //队列是否为空
    boolean isEmpty();
    //入队
    void enqueue(E e);
    //出兑
    E dequeue();
    //得到队首元素
    E getFront();
}
