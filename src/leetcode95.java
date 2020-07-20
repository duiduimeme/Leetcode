import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class leetcode95 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    public List<TreeNode> generateTrees(int n) {
        if(n==0) return new ArrayList<TreeNode>();
        return generate(1,n);
    }
    public List<TreeNode> generate(int a,int b){
        LinkedList<TreeNode> all_trees = new LinkedList<TreeNode>();
        if (a > b) {
            all_trees.add(null);
            return all_trees;
        }
        for(int i=a;i<=b;i++){
            List<TreeNode> left_trees = generate(a, i - 1);
            List<TreeNode> right_trees = generate(i + 1, b);
            for(TreeNode left: left_trees){
                for(TreeNode right:right_trees){
                    TreeNode current_tree = new TreeNode(i);
                    current_tree.left = left;
                    current_tree.right = right;
                    all_trees.add(current_tree);
                }
            }
        }
        return all_trees;
    }

}
