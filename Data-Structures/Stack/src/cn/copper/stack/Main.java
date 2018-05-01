package cn.copper.stack;

public class Main {

    public static void main(String[] args) {

        ArrayStack<Integer> stack = new ArrayStack<Integer>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }
        for (int i = 0; i <5 ; i++) {
            stack.pop();
            System.out.println(stack);
        }

    }
}
