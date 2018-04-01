# java常用API---String,StringBuffer,StringBuilder

* String基本知识
* StringBuffer
* StringBuilder







### String基本知识
* String为final对象，没有子类
* 字符串皆是对象
* String对象是不变的,数据可以共享.
* String类中的equals方法重写了Object类的方法，其判断的是内容而不是地址

>
 	String str1 = "abc";//在内存中只有一个对象
 	String str2 = new String("abc");//在内存中有两个对象，new String() 创建出的对象和构造函数的参数"abc"对象
  	System.out.println(str1==str2);//false...比较地址
  	System.out.println(str1.equals(str2));//true...判断的是内容而不是地址



### StringBuffer
* 线程安全的可变字符序列，缓冲区不可以修改，内容可以修改,类似于容器，效率低,适用于多线程.
* 字符长度，可添加任意数据，将所有数据转化成字符串.
* 数据最终要通过toString()转换成字符串才能操作.
* 数组元素独立，StringBuffer数据元素不独立.
### StringBuilder
* 线程不安全的可变字符序列(不保证同步),效率高,适用于单线程
