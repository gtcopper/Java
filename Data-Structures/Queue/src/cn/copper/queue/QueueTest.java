package cn.copper.queue;

public class QueueTest {

    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<Integer>();
        for (int i = 0; i < 5; i++) {
            queue.enqueue(i);
            System.out.println(queue);
        }
        for (int i = 0; i <2 ; i++) {
            queue.dequeue();
            System.out.println(queue);
        }
    }
}
