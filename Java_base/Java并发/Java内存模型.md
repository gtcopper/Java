# Java内存模型
---

## Java并发编程问题

### 并发问题原因 
* 原因 : CPU的发展导致CPU的执行速度远大于内存读取和写入的速度，导致CPU会浪费大量时间等待内存读取和写入。所以为了解决这个问题，在CPU处引入了高速缓存，在单核CPU不存在缓存一致性问题，在多核CPU就会出现缓存一致性问题，因为每个CPU都有自己的高速缓存，可以独立的进行读取和写入，故会产生一致性问题。

### 并发三大问题
* **原子性问题** **可见性问题** **有序性问题**
* `原子性` : 指一个操作在CPU中要么全部执行完，要么都不执行。
* `可见性` : 指多个线程访问同一个变量，其中一个线程对该变量进行了修改，其他线程都能立即看到修改后的值。
* `有序性` : 指程序执行的顺序按照代码的先后顺序执行。
* 缓存一致性问题就是可见性问题，处理器优化会导致原子性问题，指令重排会导致有序性问题。	

### 什么是内存模型
* 定义 : 为了保证共享内存的正确性(原子性，可见性，有序性)，内存模型定义了共享内存系统中多线程读写操作行为的规范。
* 内存模型解决并发问题的主要两种方式 : **限制处理器优化**和**使用内存屏障**	
  * 限制处理器优化保证内存操作的原子性
  * 使用内存屏障保证可见性，保证每个线程都可以读取到主存中最新的值。

### Java内存模型(JMM)
* 定义 : Java内存模型就是一种符合内存模型规范的，屏蔽各种硬件和操作系统的访问差异的，保证Java程序在各平台下对内存访问都能保证效果一致的机制及规范。
* Java内存模型规定了所有的变量都存储在**主内存**中，每条线程还有自己的**工作内存**,线程的工作内存中保存了该线程中是用到的变量的**主内存副本拷贝**，线程对变量的所有操作都必须在工作内存中进行，而**不能直接读写主内存**。	不同的线程之间也无法直接访问对方工作内存中的变量，线程间变量的传递均需要自己的工作内存和主存之间进行数据同步进行。
* JMM作用 : JMM就作用于工作内存和主存之间数据同步过程。他规定了如何做数据同步以及什么时候做数据同步。
* JMM是一种规范，目的是解决由于多线程通过共享内存进行通信时，存在的本地内存数据不一致、编译器会对代码指令重排序、处理器会对代码乱序执行等带来的问题。	

### Java内存模型的实现
* 在Java中提供了一系列和并发处理相关的关键字，比如volatile、synchronized、final、concurren包等。其实这些就是Java内存模型封装了底层的实现后提供给程序员使用的一些关键字。
* Java如何保证原子性，可见性，有序性？
  * **原子性** : 在Java中，为了保证原子性，提供了两个高级的字节码指令**monitorenter**和**monitorexit**,在Java中对应的关键字就是**synchronized**,因此在Java中可以使用synchronized来保证方法和代码块内的操作是原子性的。
  * **可见性** : Java内存模型是通过在变量修改后将新值同步回主内存，在变量读取前从主内存刷新变量值的这种依赖主内存作为传递媒介的方式来实现的。
     * Java中的**volatile**关键字提供了一个功能，那就是被其修饰的变量在被修改后可以立即同步到主内存，被其修饰的变量在每次是用之前都从主内存刷新。因此，可以使用volatile来保证多线程操作时变量的可见性。
     * 除了volatile，Java中的**synchronized**和**final**两个关键字也可以实现可见性。
  * **有序性** : 
      * 在Java中，可以使用synchronized和volatile来保证多线程之间操作的有序性。实现方式有所区别：
     * volatile关键字会禁止指令重排。synchronized关键字保证同一时刻只允许一条线程操作。