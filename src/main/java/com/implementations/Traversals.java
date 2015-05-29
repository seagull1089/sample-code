package com.implementations;

import java.util.Iterator;
import java.util.Stack;

/**
 * Created by aragipindi on 5/21/15.
 */
class Tree{
    public final static class Node{
        public final  int data;
        public Node left,right;
        public Node(int data,Node left,Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static Node mkNode(int data,Node left,Node right){
        return new Node(data,left,right);
    }
    public static Node mkNode(int data){
        return new Node(data,null,null);
    }
    public static Node createTree1(){
        return mkNode(1,mkNode(2,mkNode(3),mkNode(4)),mkNode(5,mkNode(6),mkNode(7)));
    }


    public static Iterator<Node> getIterator(Node node){
        return new TreeIterator(node);
    }
    private static class TreeIterator implements Iterator<Node>{

        private Stack<Node> localStack = new Stack<Node>();
        public TreeIterator(Node node){
            pushAllLeftNodes(node);
        }

        private void pushAllLeftNodes(Node node){
            Node tmp = node;
            while(tmp != null){
                localStack.add(tmp);
                tmp = tmp.left;
            }
        }

        @Override
        public boolean hasNext() {
            return !localStack.isEmpty();
        }

        @Override
        public Node next() {
            if(!localStack.isEmpty()){
                Node next = localStack.pop();
                pushAllLeftNodes(next.right);
                return next;
            }
            return null;
        }
    }

    public static void inOrder(Node n){
        if(n != null){
            inOrder(n.left);
            System.out.println(n.data);
            inOrder(n.right);
        }
    }

    //Inorder traversal of binary tree to double linked list

    public static final class LinkedNode{
        public int data;
        public LinkedNode next,prev;
        public LinkedNode(int data,LinkedNode next, LinkedNode prev){
            this.data = data;
            this.next = next;
            this.prev = prev;
        }


        public static LinkedNode getInorderDoublyLinkedList(Node root){
            Stack<Node> treeStack = new Stack<>();
            Node tmp = root;
            LinkedNode prev = null,head = null;

            while(tmp != null){
                treeStack.add(tmp);
                tmp = tmp.left;
            }
            while(!treeStack.isEmpty()){
                Node current = treeStack.pop();
                // do processing on current
                if(prev == null){
                    prev = head = new LinkedNode(current.data,null,null);
                }else{
                    LinkedNode present = new LinkedNode(current.data,null,prev);
                    prev.next = present;
                    prev = present;
                }

                current = current.right;
                while(current!=null){
                    treeStack.push(current);
                    current = current.left;
                }

            }
            return head;
        }

    }



}


public class Traversals {
    public static void main(String[] args){
        Tree.Node root = Tree.createTree1();
        Tree.inOrder(root);

        System.out.println("=====");
        Iterator<Tree.Node> it = Tree.getIterator(root);
        while(it.hasNext()){
            System.out.println(it.next().data);
        }
        System.out.println("=======");
        Tree.LinkedNode ll = Tree.LinkedNode.getInorderDoublyLinkedList(root);
        while(ll != null){
            System.out.println(ll.data);
            ll = ll.next;
        }

    }
}
