package cn.copper.linkedlist;

/**
 * 模拟数组的实现类
 */
public class Array<E> {

    private E[] data;//存放数据的数组
    private int size;//数组的实际大小

    /**
     * 传入数组的容量，创建指定大小的数组
     * @param capacity
     */
    public Array(int capacity){
        data = (E[])new Object[capacity];//不能直接new泛型数组,new出Object后强转成E[]类型
        size = 0;
    }
    /**
     * 默认构造器指定数组容量大小
     */
    public Array(){
       this(10);
    }
    /**
     * 得到数组实际的大小
     * @return
     */
    public int getSize(){
        return size;
    }
    /**
     * 得到数组的容量
     * @return
     */
    public  int getCapacity(){
        return data.length;
    }
    /**
     * 判断数组是否为空
     * @return
     */
    public boolean isEmpty(){
        return  size == 0;
    }
    /**
     * 在数组尾部添加元素
     * @param e
     */
    public void addLast(E e){
//        if(size == data.length)
//            throw new IllegalArgumentException("Add last failed.Arr is full");
//        data[size] = e;
//        size++;
        add(size,e);
    }
    /**
     * 在数组头部添加元素
     * @param e
     */
    public  void addFirst(E e){
        add(0,e);
    }
    /**
     * 在指定位置添加元素
     * @param index
     * @param e
     */
    public void add(int index,E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Add last failed.Arr bound is failed");
        }
        if(size == data.length)
            resize(2 * data.length);
        for(int i = size-1; i>=index;i--){
            data[i+1] = data[i];
        }
        data[index] = e;
        size++;

    }
    /**
     * 得到指定索引位置的元素值
     * @param index
     * @return
     */
    public E get(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Add last failed.Arr index is illegal");
        }
        return data[index];
    }

    /**
     * 得到数组的第一个元素
     * @return
     */
    public  E getFirst(){
        return get(0);
    }
    /**
     * 得到数组中最后一个元素
     * @return
     */
    public  E getLast(){
        return get(size-1);
    }
    /**
     * 通过指定元素数据查找元素所在的索引(返回第一个查找到的位置)
     * @param e
     * @return
     */
    public int find(E e){
        for (int i = 0; i <size ; i++) {
            if(data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }
    /**
     * 查到到指定数据的所有索引值，并返回s
     */
    public Array findAll(E e){
        Array arr = new Array(10);
        int index = 0;
        for (int i = 0; i < size; i++) {
            if(data[i].equals(e)) {
                arr.addLast(i);
            }
        }
        return arr;
    }
    /**
     * 设置数组指定索引位置的元素值
     * @param index
     * @param e
     */
    public void set(int index,E e){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Add last failed.Arr index is illegal");
        }
        data[index] = e;
    }
    /**
     * 检测数组中是否包含元素
     * @param e
     * @return
     */
    public boolean contains(E e){
        int temp = find(e);
        if(temp != -1){
            return true;
        }
        return false;
    }
    /**
     * 删除指定索引的元素,并返回所删除元素的值
     * @param index
     */
    public E remove(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Add last failed.Arr index is illegal");
        }
        for (int i = index + 1; i < size ; i++) {
            data[i-1] = data[i];
        }
        size--;
        data[size] = null;//便于垃圾回收,处理闲逛对象 loitering Object
        if(size == data.length / 4 && data.length / 2 != 0){
            resize(data.length / 2);
        }
        return data[index];
    }
    /**
     * 删除数组第一个元素
     */
    public E removeFirst(){
        return remove(0);
    }
    /**
     * 删除数组最后一个元素
     */
    public E removelast(){
        return remove(size-1);
    }
    /**
     * 删除数组中指定数据的元素
     * @return
     */
    public boolean removeElement(E e){
        int index = find(e);
        if(index !=- 1) {
            remove(index);
            return true;
        }
        return false;
    }
    /**
     * 删除数组中指定的所有元素
     */
    public void removeAllElement(E e){
        int index = 0;
        while((index =  find(e)) != -1){
            remove(index);
        }
    }
    /**
     *更改数组指定索引的数据值
     */
    public void update(int index,E e){
       set(index,e);
    }
    /**
     * 转换成字符串输出
     * @return
     */
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array :size %d Array : capacity = %d\n",size,data.length));
        res.append('[');
        for (int i = 0; i < size ; i++) {
            res.append(data[i]);
            if( i != size - 1)
            {
                res.append(',');
            }
        }
        res.append(']');
        return res.toString();
    }
    /**
     *扩容,实现动态数组
     * @param newCapacity
     * @return
     */
    private void resize(int newCapacity){
        E[] newData = (E[])new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
}
