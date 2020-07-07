public class leetcode44 {
    /*44. 通配符匹配
    *给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
    '?' 可以匹配任何单个字符。
    '*' 可以匹配任意字符串（包括空字符串）。
    两个字符串完全匹配才算匹配成功。
    说明:
        s 可能为空，且只包含从 a-z 的小写字母。
        p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
    * */
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for(int i=1;i<p.length()+1;i++){
            if(p.charAt(i-1)=='*'){
                dp[0][i]=true;
            }else{
                break;
            }
        }
        for(int i=1;i<=s.length();i++){
            for(int j=1;j<=p.length();j++){
                if('*'==p.charAt(j-1)){
                    //*两种情况：
                    // 匹配空字符串，这样的话直接匹配dp[i][j-1],表示不算*看模式能否和字符串匹配。
                    // 匹配多次，等于直接忽略了字符串的第i位，因为它可以被*匹配，同时不会“损耗”掉匹配串的*dp[i-1][j]。
                    dp[i][j] = dp[i][j-1]||dp[i-1][j];
                } else if (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
