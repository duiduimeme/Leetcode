import java.util.List;

public class test {
    public int findIndex(int[] num,int target){
        int res = -1;
        if(num.length==0) return res;
        for(int i=0;i<num.length;i++){
            if(num[i]==target){
                res = i;
                break;
            }
        }
        return res;
    }

}
