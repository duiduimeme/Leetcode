import java.util.ArrayList;
import java.util.List;

public class leetcode54 {
    /*leetcode54 螺旋矩阵
     *给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix==null||matrix.length==0) return res;
        int[][] position = {{0,1},{1,0},{0,-1},{-1,0}};
        int xlen = matrix.length,ylen = matrix[0].length;
        int[] margin = {0,ylen-1,xlen-1,0};
        int i=0,j=0;
        int dir = 0;
        while(res.size()<xlen*ylen){
            res.add(matrix[i][j]);
            i+=position[dir][0];
            j+=position[dir][1];
            if(!((i >= margin[0] && i <= margin[2]) && (j >= margin[3] && j <= margin[1]))){
                margin[dir] = dir==0||dir==3 ? margin[dir]+1:margin[dir]-1;
                i-=position[dir][0];
                j-=position[dir][1];
                dir = (dir+1)%4;
                i+=position[dir][0];
                j+=position[dir][1];
            }
        }
        return res;
    }
}
