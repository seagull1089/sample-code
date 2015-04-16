package com.implementations;

/**
 * Created by aragipindi on 4/15/15.
 */
public class BinaryTrees {
    public static class Node{
        public final Node left,right;
        public int data;
        public Node(int data,Node left,Node right){
            this.left = left;
            this.right  = right;
        }
    }

    public static boolean isMirror(Node root1,Node root2){
        if(root1 != null && root2 != null && root1.data != root2.data) return false;
        if((root1 == null && root2!=null) || (root2 ==null && root1 != null)) return false;
        if(root1!= null && root2!=null){
            return isMirror(root1.left,root2.right) && isMirror(root1.right,root2.left);
        }
        return true;
    }

}
