package com.interview.btree;


//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class MergeTrees {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        TreeNode res = merge(t1, t2);
        if (res != null && t1 != null && t2 !=null) {
            res.left = mergeTrees(t1.left, t2.left);
            res.right = mergeTrees(t1.right, t2.right);
        }
        return res;
    }

    public TreeNode merge(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return null;
        else if (t1 != null && t2 == null) return t1;
        else if (t1 == null && t2 != null) return t2;
        else return new TreeNode(t1.val + t2.val);
    }

    public static void printTree(TreeNode r) {
        if (r==null) return;
        System.out.println(r.val);
        printTree(r.left);
        printTree(r.right);
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(3);
        t1.right = new TreeNode(2);
        t1.left.left = new TreeNode(5);
        t1.left.right = null;
        t1.right.left = null;
        t1.right.right = null;

        TreeNode t2 = new TreeNode(2);
        t2.left = new TreeNode(1);
        t2.right = new TreeNode(3);
        t2.left.left = null;
        t2.left.right = new TreeNode(4);
        t2.right.left = null;
        t2.right.right = new TreeNode(7);

        //printTree(t1);

        MergeTrees m = new MergeTrees();
        printTree(m.mergeTrees(t1, t2));
    }

}
