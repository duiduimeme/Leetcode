import java.util.ArrayList;
import java.util.List;

//将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
// 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
// L   C   I   R
//E T O E S I I G
//E   D   H   N
public class leetcode6 {
    public static String convert(String s, int numRows) {
       if(numRows<2) return s;
       List<StringBuilder> list = new ArrayList<>();
       for(int i=0;i<numRows;i++){
           list.add(new StringBuilder());
       }
       int i=0,flag=-1;
       for(char c:s.toCharArray()){
           list.get(i).append(c);
           if(i==numRows-1||i==0){
               flag = -flag;
           }
           i+=flag;

       }
       StringBuilder res = new StringBuilder();
       for(StringBuilder str:list){
           res.append(str);
       }
       return res.toString();
    }

    public static void main(String[] args) {
        leetcode6 res = new leetcode6();
        String re = leetcode6.convert("PAYPALISHIRING",3);
        System.out.println(re);
    }
}
