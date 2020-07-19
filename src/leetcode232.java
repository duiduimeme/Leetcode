import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class leetcode232 {

    Queue<Integer> queue;
    public leetcode232() {
        queue = new LinkedList<>();

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        queue.add(x);
        for(int i=0;i<queue.size();i++)
            queue.add(queue.poll());
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return queue.poll();
    }

    /** Get the front element. */
    public int peek() {
        return queue.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return queue.size() == 0;
    }
}
