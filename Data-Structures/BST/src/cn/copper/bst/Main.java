package cn.copper.bst;

public class Main {

    public static void main(String[] args) {
        BST<Integer> bst = new BST<Integer>();
        //int[] nums = {5,3,6,8,4,2};
        int[] nums = {28,30,16,13,22,29,42};
        for (int i = 0; i < nums.length; i++) {
            bst.add(nums[i]);
        }
//        System.out.println("--前序遍历--");
//       bst.preOrder();
        System.out.println();
       // bst.preOrderNR();
       // bst.layOrder();
       // System.out.println(bst);
//        System.out.println("--中序遍历--");
//        bst.inOrder();
//        System.out.println("--后序遍历--");
//        bst.endOrder();
//        System.out.println( bst.minuNum());
//        System.out.println(bst.minuNumNR());
//        System.out.println(bst.maxNum());
//        System.out.println(bst.maxNumNR());
          System.out.println(bst.removeMin());
        System.out.println();
        //System.out.println(bst);
        System.out.println(bst.removeMax());
    }
}
