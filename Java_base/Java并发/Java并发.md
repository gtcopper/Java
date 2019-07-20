# Java并发

### 线程安全定义?

### 并发三特性
  * 原子性
  * 可见性
  * 有序性

###Java内存模型

### Java锁
##### 公平锁与非公平锁
##### 可重入锁
##### 独享锁与共享锁
##### 乐观锁与悲观锁
##### 互斥锁与读写锁
##### 分段锁
##### 自旋锁
##### 锁的四种状态
* 无锁
* 偏向锁
* 轻量级锁
* 重量级锁

### synchronized和ReentrantLock区别与选择

### volatile
 * volatile是什么?
 * volatile作用
 * volatile基本实现

### CAS(Compare And Swap)

### ThreadLocal


### Java并发基本构建模块(juc)
##### ConcurrentHashMap
##### CopyOnWriteArrayList
##### 同步工具类
* CountDownLatch(闭锁)
* FutureTask
* Semaphore(信号量)
* CyclicBarrier(栅栏)
