package cn.copper.linkedlist;

import java.util.Random;

/**
 * 测试数组实现的队列和链表实现的队列时间性能对比
 */
public class QueueTest2 {

    private static double testQueue(Queue<Integer> q ,int opCount){
        long startTime = System.nanoTime();

        Random random = new Random();

        for (int i = 0; i < opCount; i++) {
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            q.dequeue();
        }
        long endTime = System.nanoTime();
        return (endTime-startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        int opCount = 1000000;
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<Integer>();
        LoopQueue<Integer> loopQueue = new LoopQueue<Integer>();
        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<Integer>();

        double arrayQueueTime = testQueue(arrayQueue,opCount);
        double loopQueueTime = testQueue(loopQueue,opCount);
        double linkedListQueueTime = testQueue(linkedListQueue,opCount);

        System.out.println("arrayQueueTime : "+arrayQueueTime+" s ");
        System.out.println("loopQueueTime : "+loopQueueTime+" s ");
        System.out.println("linkedListQueueTime : "+linkedListQueueTime+" s ");
    }
}
