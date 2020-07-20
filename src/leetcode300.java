public class leetcode300 {
    /*leetcode300最长上升子序列
    给定一个无序的整数数组，找到其中最长上升子序列的长度。
     */
    public int lengthOfLIS(int[] nums) {
        if(nums.length==0) return 0;
        int max=1;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i <nums.length; i++) {
            int temp = 0;
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    temp = Math.max(dp[j],temp);
                }
            }
            dp[i] = temp+1;
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
