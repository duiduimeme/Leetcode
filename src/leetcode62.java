import java.util.Arrays;

public class leetcode62 {
    /*leetcode62. 不同路径
        csdn:https://blog.csdn.net/Lizejin961019/article/details/107139417


    *一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
    机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
    问总共有多少条不同的路径？
    * */
    public int uniquePaths1(int m, int n) {
        int[][] db = new int[m][n];
        for(int i=0;i<m;i++) db[i][0] = 1;
        for(int j=0;j<n;j++) db[0][j] = 1;
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                db[i][j] = db[i-1][j]+db[i][j-1];
            }
        }
        return db[m-1][n-1];
    }
    public int uniquePaths2(int m, int n) {
        int[] cur = new int[n];
        Arrays.fill(cur,1);
        for (int i = 1; i < m;i++){
            for (int j = 1; j < n; j++){
                cur[j] += cur[j-1] ;
            }
        }
        return cur[n-1];
    }

}
