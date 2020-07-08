import java.util.Arrays;

public class leetcode16 {
    public int threeSumClosest(int[] nums, int target) {
        if(nums.length<3||nums==null) return 0;
        int sum=nums[0]+nums[1]+nums[2];
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            int l = i+1,r = nums.length-1;
            while(l<r){
                int temp = nums[i]+nums[l]+nums[r];
                if(Math.abs(target-sum)>Math.abs(target-temp)){
                    sum = temp;
                }
                if(temp>target) r--;
                else if(temp<target)l++;
                else return sum;
            }
        }
        return sum;
    }
}
