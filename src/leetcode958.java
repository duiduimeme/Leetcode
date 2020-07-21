import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class leetcode958 {
    /*958. 二叉树的完全性检验

    * */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public boolean isCompleteTree(TreeNode root) {
        if(root==null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode prev = root;
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if (prev == null && node != null)
                return false;
            if (node != null) {
                queue.add(node.left);
                queue.add(node.right);
            }
            prev = node;
        }
        return true;
    }
}
