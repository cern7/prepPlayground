package list;

public class MinStack {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(15);
        minStack.push(5);
        minStack.push(3);
        minStack.push(15);
        minStack.push(12);
        minStack.pop();
        minStack.pop();
        minStack.pop();
        minStack.pop();


    }

    class Node {
        int val;
        int min;
        Node next;

        public Node() {
        }

        public Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }

    int min;
    Node head;
    Node node;

    public MinStack() {
    }

    public void push(int val) {
        if (head == null) {
            head = new Node(val, val, head);
            min = val;
        } else {
            int tempMin = min < val ? min : val;
            head = new Node(val, tempMin, head);
            min = tempMin;
        }
    }

    public void pop() {
        if (head.next != null) {
            min = head.next.min;
            head = head.next;
        } else {
            head = null;
            min = Integer.MIN_VALUE;
        }
        System.gc();
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return min;
    }
}
