import java.util.ArrayList;
import java.util.List;

public class leetcode1441 {
    /*leetcode1441 用栈操作构建数组
    *
    * */
    public List<String> buildArray(int[] target, int n) {
        int l = target.length;
        List<String> sl = new ArrayList<String>();
        int j = 0;
        for(int i = 1; i<=n;i++){
            if(i < target[j] ){  // 1.不在target中
                sl.add("Push");
                sl.add("Pop");
            }else{    //2.在target中
                sl.add("Push");
                j++;
                if(j == l){ //3. 终止条件
                    break;
                }
            }
        }
        return sl;
    }
}
