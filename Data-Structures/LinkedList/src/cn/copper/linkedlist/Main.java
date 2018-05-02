package cn.copper.linkedlist;

public class Main {

    public static void main(String[] args) {
	    LinkedList<Integer> linkedList = new LinkedList<Integer>();
	    linkedList.add(0,100);
        linkedList.add(1,200);
        linkedList.add(2,300);
        linkedList.add(3,0);
        System.out.println(linkedList.contains(100));
        System.out.println(linkedList.remove(3));
        System.out.println(linkedList.toString());
    }
}
