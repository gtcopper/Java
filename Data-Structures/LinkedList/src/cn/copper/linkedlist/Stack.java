package cn.copper.linkedlist;

public interface Stack<E> {

    //得到栈的大小
    int getSize();
    //判断栈是否为空
    boolean isEmpty();
    //压栈
    void push(E e);
    //出栈
    E pop();
    //查看栈顶元素
    E peek();

}
