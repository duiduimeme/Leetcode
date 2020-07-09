import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode18 {
    /*leetcode18
    *给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
    注意：
    答案中不可以包含重复的四元组。
    * */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null||nums.length<4) return res;
        Arrays.sort(nums);
        int len = nums.length-3;
        for (int i = 0; i <len; i++) {
            if(i>0&&nums[i]==nums[i-1]) continue;
            for(int j=nums.length-1;j>i+2;j--){
                int l=i+1,r = j-1;
                while(l<r){
                    int sum = nums[i]+nums[l]+nums[r]+nums[j];
                    if(sum==target){
                        List<Integer> list= Arrays.asList(nums[i],nums[l],nums[r],nums[j]);
                        if(!res.contains(list)) res.add(list);
                        while(l<r&&nums[l]==nums[l+1]) l++;
                        while(l<r&&nums[r]==nums[r-1]) r--;
                        l++;
                        r--;
                    }
                    if(sum<target) l++;
                    if(sum>target) r--;

                }
            }
        }
        return res;
    }
}
