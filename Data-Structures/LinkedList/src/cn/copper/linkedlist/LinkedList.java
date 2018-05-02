package cn.copper.linkedlist;

public class LinkedList<E> {

    private class Node<E> {
        public E e;
        public Node next;

        public Node(E e , Node next){
            this.e = e;
            this.next = next;
        }

        public Node(E e){
            this(e,null);
        }

        public Node(){
            this(null,null);
        }
        @Override
        public String toString(){
            return  e.toString();
        }
    }
    private Node dummyHead ;//虚拟有节点，0索引的前一个节点
    private int size;

    public LinkedList(){
        dummyHead = new Node(null,null);
        size = 0;
    }
    //获取链表中元素个数
    public int getSize(){
        return  size;
    }
    //判断链表是否为空
    public boolean isEmpty(){
        return size == 0;
    }
    //在链表中添加元素(从0开始)
    public void add(int index,E e){
        if(index <0 || index > size){
            throw new IllegalArgumentException("Index is illeagl");
        }
//        if(index == 0){
//            addFirst(e);
//        }else{
            Node prev = dummyHead;
            for (int i = 0; i < index; i++) {
                prev = prev.next;
                if (prev==null){
                    prev = new Node();
                }
            }
//            Node node = new Node(e);
//            node.next = prev.next ;
//            prev.next = node;
            if (prev.next != null){
                prev.next.e = e;
            }else {
                prev.next = new Node(e, prev.next);
                size++;
            }
        }
    //向链表头部添加元素
    public void addFirst(E e){
//        Node node = new Node(e);
//        node.next = head;
//        head = node;
        add(0,e);
    }
    //向链表尾部添加元素
    public void addLast(E e){
        add(size,e);
    }
    //通过索引获取链表中元素
    public E get(int index){
        if(index <0 || index > size)
            throw new IllegalArgumentException("Index is illeagl");
        Node cur = dummyHead;
        for (int i = 0; i < index; i++)
            cur = cur.next;
        return (E) cur.e;
    }
    //获取链表最后一个元素
    public E getFirst(){
        return get(0);
    }
    //获取链表第一个元素
    public E getLast(){
        return get(size-1);
    }
    //给定索引值,设置链表值
    public void set(int index,E e){
        if(index <0 || index > size)
            throw new IllegalArgumentException("Index is illeagl");
        Node cur = dummyHead;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }
    //给定元素值，判断链表中是否存在该值
    public boolean contains(E e){
        Node cur = dummyHead.next;
//        for (int i = 0; i < size; i++) {
//            if(cur.e.equals(e)){
//                return true;
//            }
//            cur = cur.next;
//        }
        while(cur != null){
            if(cur.e.equals(e)){
               return true;
            }
            cur = cur.next;
        }
        return false;
    }
    //删除链表中指定索引的元素
    public E remove(int index){
        if(index <0 || index > size)
            throw new IllegalArgumentException("Index is illeagl");
        //方法一：
//        Node prev = dummyHead.next;
//        if(index == 0){
//            dummyHead.next =  prev.next ;
//            prev.next = null;
//            return (E)prev;
//        }
//        for (int i = 0; i <index - 1; i++) {
//            prev = prev.next;
//        }
//        Node delNode = prev.next;
//        prev.next = delNode.next;
//        delNode.next = null;
//        return (E)delNode.e;
        //方法二：
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node delNode = prev.next;
        prev.next = delNode.next;
        delNode.next = null;
        return (E)delNode.e;
    }
    //删除链表中第一个元素
    public E removeFirst(){
        return remove(0);
    }
    //删除链表中最后一个元素
    public E removeLast(){
        return remove(size-1);
    }
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        Node cur = dummyHead.next;
        while(cur != null){
            res.append(cur+"->");
            cur = cur.next;
        }
        res.append("Null");
        return res.toString();
    }
}
