package cn.copper.bst;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
/**
 * 二分搜索树的实现
 * @param <E>
 */
public class BST<E extends Comparable<E>> {

    private class Node{
        public E e;
        public Node left,right;

        public Node(E e){
            this.e = e;
            left = null;
            right = null;
        }
    }
    private Node root;
    private int size;

    public BST(){
        root = null;
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }
    //在二分搜索树中添加元素
    public void add(E e){
        root = add(root,e);
    }
    //    //向Node为根的二分搜索树中插入元素，递归实现
//    private void add(Node node,E e){
//
//        if(e.equals(node.e)){
//            return;
//        }else if(e.compareTo(node.e) <0 && node.left == null){
//            node.left = new Node(e);
//            size++;
//            return;
//        }else if(e.compareTo(node.e) >0 && node.right == null){
//            node.right = new Node(e);
//            size++;
//            return;
//        }
//        if(e.compareTo(node.e) <0){
//           add(node.left,e);
//        }else{
//            add(node.right,e);
//        }
//    }
    //返回插入新节点后二分搜索树的根
    private Node add(Node node,E e){

        if(node == null){
            size++;
            return new Node(e);
        }
        if(e.compareTo(node.e) <0){
            node.left =  add(node.left,e);
        }else if(e.compareTo(node.e) >0){
            node.right = add(node.right,e);
        }
        return node;
    }
    //判断二分搜索树中是否包含某元素
    public boolean contains(E e){
        return contains(root,e);
    }
    //以node为根查看二分搜索树中
    private boolean contains(Node node,E e){

        if(node == null){
            return false;
        }
        if(e.compareTo(node.e) == 0){
            return true;
        }else if(e.compareTo(node.e) < 0){
            return contains(node.left,e);
        }else{
            return contains(node.right,e);
        }
    }
    //前序遍历
    public void preOrder(){
        preOrder(root);
    }
    //递归实现前序遍历
    private void preOrder(Node node){

        if(node == null){
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }
    //二分搜索树前序遍历非递归实现
    public void preOrderNR(){
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node cur = stack.pop();
            System.out.println(cur.e);

            if(cur.right != null) {
                stack.push(cur.right);
            }
            if(cur.left != null) {
                stack.push(cur.left);
            }
        }
    }
    //中序遍历
    public void inOrder(){
        inOrder(root);
    }
    //中序遍历递归实现
    private void inOrder(Node node){
        if(node == null){
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }
    //后序遍历二分搜索树s
    public void endOrder(){
        endOrder(root);
    }
    //递归实现后序遍历二分搜索树
    private void endOrder(Node node){

        if(node == null){
            return;
        }
        endOrder(node.left);
        endOrder(node.right);
        System.out.println(node.e);
    }
    //二分搜索树的层序遍历，非递归实现
    public void layOrder(){
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            System.out.println(cur.e);
            if(cur.left != null){
                queue.add(cur.left);
            }
            if(cur.right != null){
                queue.add(cur.right);
            }
        }
    }
    //返回二分搜索树最小值,递归实现
    public E minuNum(){
        if(size == 0){
            throw new RuntimeException("bst is empty!!");
        }
        return minuNum(root).e;
    }
    // 返回以node为根的二分搜索树最小值所在的节点
    private Node minuNum(Node node){
        if(node.left == null){
            return node;
        }
        return minuNum(node.left);
    }
    //返回最小值的非递归实现
    public E minuNumNR(){
        if(size == 0){
            throw new RuntimeException("bst is empty!!");
        }
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        Node cur = null;
        while(!stack.isEmpty()){
            cur = stack.pop();
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
        return cur.e;
    }
    //返回二分搜索树最大值,递归实现
    public E maxNum(){
        if(size == 0){
            throw new RuntimeException("bst is empty!!");
        }
        return maxNum(root).e;
    }
    // 返回以node为根的二分搜索树最大值所在的节点
    private Node maxNum(Node node){
        if(node.right == null){
            return node;
        }
        return maxNum(node.right);
    }
    //返回最大值的非递归实现
    public E maxNumNR(){
        if(size == 0){
            throw new RuntimeException("bst is empty!!");
        }
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        Node cur = null;
        while(!stack.isEmpty()){
            cur = stack.pop();
            if (cur.right != null) {
                stack.push(cur.right);
            }
        }
        return cur.e;
    }
    //从二分搜索树中删除最小值所在的节点，并返回最小值
    public E removeMin(){
        E ret = minuNum();
        root = removeMin(root);
        return ret;
    }
    //递归实现二分搜索树最小值所在节点的删除,并返回新的二分搜索树的根
    private Node removeMin(Node node) {
        if(node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }
    //从二分搜索树中删除最小值所在的节点，并返回最小值
    public E removeMax(){
        E ret = maxNum();
        root = removeMax(root);
        return ret;
    }
    //递归实现二分搜索树最小值所在节点的删除,并返回新的二分搜索树的根
    private Node removeMax(Node node) {
        if(node.right == null){
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }
    //删除指定元素所在的节点
    public void remove(E e){
        root =  remove(root,e);
    }
    //递归实现二分搜索树值为e所在节点的删除,并返回新的二分搜索树的根
    private Node remove(Node node, E e) {

        if(node == null){
            return null;
        }
        if(e.compareTo(node.e) < 0){
            node.left = remove(node.left,e);
            return node;
        }else if(e.compareTo(node.e) > 0){
            node.right = remove(node.right,e);
            return node;
        }else{//e == node.e
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }else if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }else{
                Node successor = minuNum(node.right);
                successor.right = removeMin(node.right);
                successor.left = node.left;

                node.left = node.right = null;
                return successor;
            }
        }
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        generateBSTString(root,0,res);
        return res.toString();
    }

    private void generateBSTString(Node node, int depth, StringBuilder res) {
        if(node == null){
            res.append(generateDepthString(depth)+"null\n");
            return;
        }
        res.append(generateDepthString(depth)+node.e+"\n");
        generateBSTString(node.left,depth + 1,res);
        generateBSTString(node.right,depth + 1,res);
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString()
;    }

}
