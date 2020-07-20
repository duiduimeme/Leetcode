import javax.transaction.TransactionRequiredException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class leetcode145 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode curr = root;
        TreeNode last = null;
        while(curr!=null||!s.isEmpty()){
            if(curr!=null){
                s.push(curr);
                curr = curr.left;
            }else{
                TreeNode temp = s.peek();
                if(temp.right!=null&&temp.right!=last){
                    curr = temp.right;
                }else{
                    res.add(temp.val);
                    last=temp;
                    s.pop();
                }
            }
        }
        return res;
    }
}
