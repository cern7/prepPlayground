package list;

public class LinkedListImpl {
    static class Node<E> {
        private E value;
        private Node<E> next;

        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }

        public Node(E value) {
            this(value, null);
        }

        public E value() {
            return value;
        }

        public void next(Node<E> next) {
            this.next = next;
        }
    }
}
