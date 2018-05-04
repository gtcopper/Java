package cn.copper.linkedlist;

import java.util.Random;

public class StackTest2 {

    private static double testStack(Stack<Integer> s ,int opCount){
        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            s.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            s.pop();
        }
        long endTime = System.nanoTime();
        return (endTime-startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        int opCount = 10000000;
        ArrayStack<Integer> arrayStack = new ArrayStack<Integer>();
        LinkedListStack<Integer> linkedListStack = new LinkedListStack<Integer>();

        double arrayStackTime = testStack(arrayStack,opCount);
        double linkedListStackTime = testStack(linkedListStack,opCount);

        System.out.println("arrayStackTime : "+arrayStackTime+" s ");
        System.out.println("linkedListStackTime : "+linkedListStackTime+" s ");
    }
}
