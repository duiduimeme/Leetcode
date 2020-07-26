import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class leetcode232 {

        Stack<Integer> s1;
        Stack<Integer> s2;
        public leetcode232() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }

        public void push(int x) {
            s1.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if(s2.isEmpty()){
                while (!s1.empty()){
                    s2.push(s1.pop());
                }
            }
            return s2.pop();
        }

        /** Get the front element. */
        public int peek() {
            if(s2.isEmpty()){
                while (!s1.empty()){
                    s2.push(s1.pop());
                }
            }
            return s2.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return s2.isEmpty()&&s1.isEmpty();
        }
}
