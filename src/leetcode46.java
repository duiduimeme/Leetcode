import java.util.ArrayList;
import java.util.List;

public class leetcode46 {
    /*
    * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
    * 详细过程在我的csdnblog：https://blog.csdn.net/Lizejin961019/article/details/107120614
    * */
    static List<List<Integer>> res = new ArrayList<>();
    public static List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if(nums.length==0||nums==null){
            return res;
        }
        permuteSort(0,list,nums.length,nums);
        return res;
    }

    public static void permuteSort(int s,List<Integer> list,int len,int[] nums){
        if(s==len) {
            res.add(new ArrayList<>(list));
        }
        for(int i=s;i<len;i++){
            swap(nums,s,i);
            list.add(nums[s]);
            permuteSort(s+1,list,len,nums);
            list.remove(list.size()-1);
            swap(nums,s,i);
        }
    }
    public static void swap(int[] nums,int a,int b){
        int t =nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }

    public static void main(String[] args) {
        int[] num = new int[]{1,2,3};
        permute(num);
        System.out.println(res);
    }
}
