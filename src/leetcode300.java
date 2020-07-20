public class leetcode300 {
    /*leetcode300最长上升子序列
    给定一个无序的整数数组，找到其中最长上升子序列的长度。
     */
    public int lengthOfLIS(int[] nums) {
        int max = 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            int temp = 0;
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    temp = Math.max(temp,dp[j]);
                }
            }
            dp[i] = temp+1;
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
