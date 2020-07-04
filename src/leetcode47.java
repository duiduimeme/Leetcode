import java.util.*;

public class leetcode47 {

    /*
    *47、全排列2给定一个可包含重复数字的序列，返回所有不重复的全排列。
    * */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        if(nums.length==0) return res;
        //deque容器为一个给定类型的元素进行线性处理，像向量一样，
        //它能够快速地随机访问任一个元素，并且能够高效地插入和删除容器的尾部元素。
        //但它又与vector不同，deque支持高效插入和删除容器的头部元素，因此也叫做双端队列。deque类常用的函数如下。
        Deque<Integer> path = new ArrayDeque<>(nums.length);
        Arrays.sort(nums);

        Sort(nums,res,0,path,used);
        return res;
    }
    public void Sort(int[] nums, List<List<Integer>> res, int start, Deque que,boolean[] used){
        if(start==nums.length){
            res.add(new ArrayList<>(que));
            return ;}
        for(int i=0;i<nums.length;i++){
            if(used[i]){
                continue;
            }
            if(i>0&&nums[i]==nums[i-1]&&!used[i-1]) {continue;}
            used[i] = true;
            que.addLast(nums[i]);
            Sort(nums,res,start+1,que,used);
            used[i] = false;
            que.removeLast();
        }
    }
    public static void main(String[] args) {
        leetcode47 solution = new leetcode47();
        int[] nums = {1, 1, 2};
        List<List<Integer>> res = solution.permuteUnique(nums);
        System.out.println(res);
    }


}
