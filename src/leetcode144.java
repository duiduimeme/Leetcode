import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class leetcode144 {
    /*leetcode144 二叉树的前序遍历
    二叉树的中序遍历
    二叉树的后序遍历
    *
    * */
    public class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root==null) return null;
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode curr = root;
        while(curr!=null||!s.isEmpty()){
            while(curr!=null){
                res.add(curr.val);
                s.push(curr);
                curr = curr.left;
            }
            curr = s.pop();
            curr = curr.right;
        }
        return res;
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root==null) return res;
        TreeNode cur = root;
        while(cur!=null||!stack.isEmpty()){
            while(cur!=null){
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }
    public List<Integer> postorderTraversal(TreeNode root){
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode last = null;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                TreeNode temp = stack.peek();
                //是否变到右子树
                if (temp.right != null && temp.right != last) {
                    cur = temp.right;
                } else {
                    list.add(temp.val);
                    last = temp;
                    stack.pop();
                }
            }
        }
        return list;
    }
}
