import java.util.ArrayList;
import java.util.List;

public class leetcode257 {
    /*
    * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
        说明: 叶子节点是指没有子节点的节点。
    * */
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        String path = new String("");
        if(root==null) return res;
        dfs(res,path,root);
        return res;
    }
    public void dfs(List<String> result,String curLevel,TreeNode node){
        if(node != null){
            curLevel += node.val;
            if(node.left == null && node.right == null){
                result.add(curLevel);
            }else{
                curLevel += "->";
                dfs(result, curLevel,node.left );
                dfs(result, curLevel, node.right);
            }
        }
    }
}
