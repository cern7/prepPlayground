package list;

public class MiddleOfLinkedList {

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode middleNode(ListNode head) {
        ListNode[] arr = new ListNode[100];
        int i = 0;
        while (head != null) {
            arr[i++] = head;
            head = head.next;
        }
        return arr[i / 2];
    }
}
