public class leetcode11 {
    /*leetcode11盛最多水的容器
    *给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，
    * 垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳
    * 最多的水。
    说明：你不能倾斜容器，且 n 的值至少为 2
    * */
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int max = 0;
        while (i < j) {
            max = height[i] > height[j] ?
                    Math.max(max,(j-i)*height[j--]):Math.max(max,(j-i)*height[i++]);
        }
        return max;
    }
}
