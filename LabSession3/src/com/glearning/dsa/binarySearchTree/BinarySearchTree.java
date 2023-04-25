package com.glearning.dsa.binarySearchTree;


import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BinarySearchTree {
    class Node {
        int val;
        Node left, right;

        Node(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
    private Node root;

    public BinarySearchTree(){
        root = null;

    }
    public void insert(int val){
        root = insert(root, val);
    }
    private Node insert(Node node, int val){
        if(node == null) {
            //root node
            return new Node(val);
        }
        if(val < node.val) {
            node.left = insert(node.left, val);
        }
        if(val > node.val) {
            node.right = insert(node.right, val);
        }
        return node;
    }

    public boolean findPairWithSum(int sum){
        Set<Integer> set = new HashSet<>();
        return findPairWithSum(root, sum, set);
    }

    private boolean findPairWithSum(Node node, int sum, Set<Integer> set) {
        if(node == null) {
            return false;
        }
        if(findPairWithSum(node.left, sum,set)){
            return true;
        }
        if(set.contains(sum- node.val)){
            System.out.println("pair found :: " +(sum-node.val)+" , "+ node.val);
            return  true;
        }
        set.add(node.val);
        return findPairWithSum(node.right,sum, set);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node root = null;
        int value=0; int num;
        int i =0;
        System.out.println("Eneter number of values to insert");
        num = sc.nextInt();
        BinarySearchTree tree = new BinarySearchTree();
        for(i = 0; i<num;i++){
            System.out.println("\nEnter Value at "+(i+1)+" : ");
            value = sc.nextInt();
            tree.insert(value);
        }
        i-=1;

        String status ="a";

        while(!status.equals("q")){
            String input;
            System.out.println("Enter a sum");
            int sum = sc.nextInt();
            if(!tree.findPairWithSum(sum)){
                System.out.println("Nodes not found for sum " + sum);
            }
            System.out.println("\nEnter q to stop or any char to continue insertion");
            status = sc.next();

        }
        sc.close();

    }


}
