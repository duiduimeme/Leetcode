public class leetcode53 {
    public int maxSubArray(int[] nums) {
        if(nums==null||nums.length==0) return 0;
        int max = nums[0];
        int sum = 0;
        for(int i:nums){
            if(sum>0)
                sum+=i;
            else sum = i;
            max = Math.max(max,sum);
        }
        return max;
    }

}
