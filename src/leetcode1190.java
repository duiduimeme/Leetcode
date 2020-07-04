import java.util.Stack;

public class leetcode1190 {

    public String reverseParentheses(String s) {
        StringBuilder res = new StringBuilder();
        char[] ch = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<ch.length;i++){
            if(ch[i]=='(')
                stack.push(i);
            if(ch[i]==')'){
                reverse(ch,stack.pop()+1,i-1);
            }
        }
        for(int i=0;i<ch.length;i++){
            if(ch[i]!='('&&ch[i]!=')')
                res.append(ch[i]);
        }
        return res.toString();
    }
    public void reverse(char[] arr, int left, int right) {

        while (right > left) {

            char tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            right--;
            left++;
        }
    }
}
