import java.util.HashMap;

public class leetcode543 {
    /*leetcode543 二叉树的直径
    *
    * */
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return ans;
    }
    public int depth(TreeNode t){
        if(t==null) return 0;
        int l = depth(t.left);
        int r = depth(t.right);
        ans = Math.max(ans,l+r);
        return Math.max(l,r)+1;
    }
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int start=0,end=0;end<s.length();end++){
            Character c = s.charAt(end);
            if(map.containsKey(c)){
                start = Math.max(map.get(c)+1,start);
            }
            map.put(c,end);
            res = Math.max(res,end-start+1);

        }
        return res;
    }
}
