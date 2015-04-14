package com.implementations;

/**
 * Created by aragipindi on 4/10/15.
 */








public class ReverseTreeStructure {
    public static class TreeNode {
        TreeNode left;
        TreeNode right;
        int data;
        TreeNode(int data,TreeNode left,TreeNode right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
       @Override
       public String toString(){
         StringBuilder builder = new StringBuilder();
           builder.append(data + "\n" );
          if(left!=null){ builder.append( "(" + data + "-left)" + left.toString() + "\n");}
              if(right!=null){ builder.append("(" + data + "-right)" + right.toString() + "\n");}

           return builder.toString();
       }

        public void print() {
            print("", true);
        }

        private void print(String prefix, boolean isTail) {
            System.out.println(prefix + (isTail ? "└── " : "├── ") + data);

            if(left != null){
                left.print(prefix +prefix + (isTail ? "    " : "│   "), false);
            }
            if(right != null){
                right.print(prefix +prefix + (isTail ? "    " : "│   "), false);
                //right.print(prefix + (isTail ?"    " : "│   "), true);
            }

            if(right != null && left != null){
                left.print(prefix + (isTail ?"    " : "│   "), true);
            }



            /*
            for (int i = 0; i < children.size() - 1; i++) {
                children.get(i).print(prefix + (isTail ? "    " : "│   "), false);
            }
            if (children.size() > 0) {
                children.get(children.size() - 1).print(prefix + (isTail ?"    " : "│   "), true);
            }
            */
        }
    }

    public static TreeNode reverse(TreeNode node) {
        //1  // 4
        // implementation here
        // root -- should become left child's right node.
        // right -- should become left child's left node.

        if (node == null) {
            return null;
        }

        TreeNode left = node.left;  // 2 // 5
        TreeNode right = node.right; //3 // 6

        TreeNode nextLevel = null;
        if (left != null) {
            nextLevel = left.left;
        } // --> 4. // null

        TreeNode current = left; // 2  // 5

        if(current == null){
            return node;
        }

        current.right = node;// 1 // 4
        node.left = null;
        node.right = null;
        current.left = right;  // 3 // 6
        //right.left = null;
        //right.right = null;
        // ( 2 - (3,1)

        TreeNode reversedNext = reverse(nextLevel);  // null //  --> reversedNext == (5 -> (6,4)) // current == (2 -> (3,1))

        if (reversedNext != null) {
            if (reversedNext.right != null) {
                reversedNext.right.right = current;
            } else {
                reversedNext.right = current;
            }
            return reversedNext;
        } else {
            return current;
        }

    }

    public static TreeNode mkNode(int data){
        return new TreeNode(data,null,null);
    }
    public static TreeNode mkNode(int data,TreeNode left,TreeNode right){
        return new TreeNode(data,left,right);
    }
    public static void main(String[] args){
        TreeNode node = mkNode(1,mkNode(2,mkNode(4,mkNode(5,mkNode(7),mkNode(8)),mkNode(6)),null),mkNode(3));
        System.out.println(node);
        node = reverse(node);
        System.out.println(node);

        System.out.println("================");
        node = mkNode(1,mkNode(2,mkNode(3),mkNode(4)),mkNode(4));
        System.out.println(node);
        node = reverse(node);
        node.print();

    }
}
