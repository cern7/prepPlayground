package list;

import java.awt.*;
import java.util.Deque;
import java.util.EmptyStackException;
import java.util.LinkedList;

public class QueueUsingStack {
    Deque<Integer> st1 = new LinkedList<>();
    Deque<Integer> st2 = new LinkedList<>();
    int frontElem;

    public static void main(String[] args) {
        QueueUsingStack q = new QueueUsingStack();
        q.push(1);
        q.push(2);
        System.out.println(q.peek());
        q.pop();
        System.out.println(q.empty());
    }

    public void push(int x) {
        if (st1.isEmpty()) {
            frontElem = x;
        }
        st1.offer(x);

    }

    public int pop() {
        if (st2.isEmpty()) {
            while (!st1.isEmpty()) {
                st2.push(st1.pop());
            }
        }
        int result = st2.pop();
        if (!st2.isEmpty()) {
            frontElem = st2.peek();
        }
        return result;
    }

    public boolean empty() {
        return st1.isEmpty() && st2.isEmpty();

    }

    public int peek() {
        return frontElem;
    }
}
