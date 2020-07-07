import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class leetcode3 {
    /*leetcode3无重复字符的最长子串
    *给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
    * */
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int left=0;
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                //加最大值是有可能出现两种字符 abba 读取2b时left更新为了2但读取a时a的前坐标将left覆盖了。
                left = Math.max(left,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-left+1);
        }
        return max;
    }

    public static void main(String[] args) {
        leetcode3 l = new leetcode3();
        System.out.println(l.lengthOfLongestSubstring("abba"));
    }
}
