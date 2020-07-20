public class leetcode33 {
    /*leetcode33搜索旋转排序数组
    *假设按照升序排序的数组在预先未知的某个点上进行了旋转。
    (例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
    搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
    * */
    public int search(int[] nums, int target) {
        int res = -1;
        int i=0,j=nums.length-1;
        while(i<j){
            if(nums[i]==target){
                res = i;
                break;
            }else i++;
            if(nums[j]==target){
                res = j;
                break;
            }
            else j--;
        }
        return res;
    }
}
