import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leetcode102 {
    /*leetcode102 二叉树层次遍历
    *
    * */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        // 创建二维数组接收每层的结点
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        // 创建队列依次存放每层的结点
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            // 创建数组来接收出队的结点，存放的是每层的结点
            List<Integer> tmp = new ArrayList<>();
            int len = q.size();
            for (int i = 0; i < len; i++) {
                // 定义 node 接收出队结点，然后加入数组 tmp 中
                TreeNode node = q.remove();
                tmp.add(node.val);
                // 如果有左右孩子，就依次入队、出队、进数组
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            // 数组每次都是放的一层的结点，然后一层一层的放入二维数组中
            ans.add(tmp);
        }
        return ans;
    }
}
