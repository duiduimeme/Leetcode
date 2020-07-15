import sun.reflect.generics.tree.Tree;

import java.util.*;

public class leetcode236 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode,TreeNode> map = new HashMap<>();
        Stack<TreeNode> s = new Stack<>();
        if(root==null) return null;
        s.push(root);
        map.put(root,null);
        while(!map.containsKey(p)||!map.containsKey(q)){
            TreeNode temp = s.pop();
            if(temp.left!=null){
                s.add(temp.left);
                map.put(temp.left,temp);
            }
            if(temp.right!=null){
                s.add(temp.right);
                map.put(temp.right,temp);
            }
        }
        Set<TreeNode> set = new HashSet<>();
        while(p!=null){
            set.add(p);
            p = map.get(p);
        }
        while(!set.contains(q)){
            q = map.get(q);
        }
        return q;
    }
}
