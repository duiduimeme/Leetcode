public class leetcode209 {
    /**leetcode209. 长度最小的子数组
     * *给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。
     */
    public int minSubArrayLen(int s, int[] nums) {
        int res = nums.length;
        int left = 0,right=0;
        while(left<nums.length){
            int sum = nums[left];
            if(sum<s){
                while(sum<s&&right<nums.length){
                    right++;
                    sum+=nums[right];
                }
            }else{
                while(sum-nums[right]>=s)
                    right--;
            }
            res = Math.min(res,right-left+1);
            left++;
        }
        return res;
    }
}
