import java.util.HashMap;
import java.util.Map;

public class leetcode990 {
    /*
    * 给定一个由表示变量之间关系的字符串方程组成的数组，每个字符串方程 equations[i] 的长度为 4，并采用两种不同的形式之一："a==b" 或 "a!=b"。在这里，a 和 b 是小写字母（不一定不同），表示单字母变量名。
    只有当可以将整数分配给变量名，以便满足所有给定的方程时才返回 true，否则返回 false。
    * 并查集
    * */
    public boolean equationsPossible(String[] equations) {
        Map<Character,Character> father = new HashMap<>();
        //建立并查集
        for(String s:equations){
            char[] chars = s.toCharArray();
            if(chars[1] == '='){
                char first = chars[0];
                char second = chars[3];
                while(father.containsKey(first) ) first = father.get(first);
                while(father.containsKey(second)) second = father.get(second);
                if(first == second) continue;
                father.put(first, second);
            }
        }
        //检查是否有错
        for(String s:equations){
            char[] chars = s.toCharArray();
            if(chars[1] == '!'){
                char first = chars[0];
                char second = chars[3];
                while(father.containsKey(first) ) first = father.get(first);
                while(father.containsKey(second)) second = father.get(second);
                if(first == second) return false;
            }
        }
        return true;
    }
}
