#Object类方法与解析
---
**Object类**的结构

![object](/object.jpg)

**Object类有12个成员方法，按用途可以分为如下:**

 1. 构造函数
 2. hashCode和equale函数判断对象是否相同
 3. 线程方法:wait(),notify(),notifyAll()
 4. clone()
 5. finalize()用于垃圾回收

**函数说明**

 + **clone()** -> 用来另存一个当前对象
 + **hashCode()**用于获取对象的哈希值，这个值的作用是检索,深入理解可参考[object深入](http://www.cnblogs.com/return/archive/2009/11/06/1597611.html)
 + 哈希值相同的对象不一定**equale()** 可参考上面
 + **equale()** 返回true的两个对象一定相同
 + **toString()和getClass()**
   * **toString**()返回一个String对象，用来标识自己 
   * **getClass**()返回一个Class对象,后面可以跟class类的方法;  用	的是谁的构造函数，那么getClass返回的就是谁的类型。 
	getClass()经常用于java反射机制
 + **wait(),wait(long),wait(long,int),notify(),notifyAll()**  
   +  体现在java**多线程**
   +  在使用的时候要求在**synchronize**语句中使用
   + **wait()**用于让当前线程失去操作权限，当前线程进入等待序列
   + **notify()**用于随机通知一个持有对象的锁的线程获取操作权限
   + **notifyAll()**用于通知所有持有对象的锁的线程获取操作权限
   + **wait(long) 和wait(long,int)**用于设定下一次获取锁的距离当前释放锁的时间间隔
 + **finalize()**
   * 在进行垃圾回收的时候会用到，匿名对象回收之前会调用到.
   ![garbageCollection](/garbageCollection.jpg)