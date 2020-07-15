import java.util.Stack;

public class leetcode394 {
    /*leetcode394 字符串解码
    *
    * */
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        Stack<Integer> stack = new Stack<>();
        Stack<String> s_res = new Stack<>();
        for(Character c:s.toCharArray()){
            if(c=='['){
                stack.push(multi);
                s_res.push(res.toString());
                multi = 0;
                res = new StringBuilder();
            }else if(c==']'){
                StringBuilder tmp = new StringBuilder();
                int cur_multi = stack.pop();
                for(int i = 0;i<cur_multi;i++)tmp.append(res);
                res = new StringBuilder(s_res.pop()+tmp);
            }else if(c >= '0' && c <= '9'){
                multi = multi*10+Integer.parseInt(c+"");
            } else res.append(c);
        }
        return res.toString();
    }
}
