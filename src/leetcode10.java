public class leetcode10 {
    /*leetcode10、正则表达式匹配
    *给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
    '.' 匹配任意单个字符
    '*' 匹配零个或多个前面的那一个元素
    所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
    说明:
        s 可能为空，且只包含从 a-z 的小写字母。
        p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
    * */
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for(int i=0;i<=p.length();i++){
            if(p.charAt(i)=='*'&&dp[0][i-1]){
                dp[0][i+1] = true;
            }
        }
        for(int i=1;i<=s.length();i++){
            for(int j=1;j<=p.length();j++){
                if(s.charAt(i)==p.charAt(j)||p.charAt(j)=='.'){
                    dp[i+1][j+1] = dp[i][j];
                }
                if(p.charAt(j)=='*'){
                    if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.'){
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    }else{
                        dp[i+1][j+1] = dp[i+1][j]||dp[i+1][j-1]||dp[i+1][j-1];
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
