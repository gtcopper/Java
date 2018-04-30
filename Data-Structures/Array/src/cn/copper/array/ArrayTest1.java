package cn.copper.array;

public class ArrayTest1 {

    public static void main(String[] args) {
        //自定义数组构造函数初始化数组
        Array arr = new Array(20);
        for (int i = 0; i < 10; i++) {
            //在数组尾部添加数据元素
            arr.addLast(i);
        }
        System.out.println(arr);
        //忘数组指定索引位置添加数据
        arr.add(1,100);
        System.out.println(arr);
        //再数组头部添加元素
        arr.addFirst(-100);
        System.out.println(arr);
        //通过索引得到数据值
        System.out.println(arr.get(3));
        //通过值数据查找索引
        System.out.println(arr.find(5));
        //设置数组
        arr.set(1,200);
        System.out.println(arr);
        //检测数组中是否包含某数据元素
//        System.out.println(arr.contains(8));
//        arr.remove(1);
//        System.out.println(arr);
//        arr.remove(2);
//        System.out.println(arr);
        arr.addLast(100);
        arr.add(3,100);
        System.out.println(arr);
        System.out.println(arr.findAll(100));
        arr.removeAllElement(100);
        System.out.println(arr);
    }

}
