public class LinkedListProblems {

    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    static class LinkedList {
        Node head;

        void insert(int data) {
            // TODO: append a new node with `data` at the end of the list
        }

        void delete(int data) {
            // TODO: remove the first node whose data == data (handle head case too)
        }

        void printList() {
            // TODO: print all nodes as "1 -> 2 -> 3 -> null"
        }
    }

    public static Node reverseLinkedList(Node head) {
        // TODO: iterative reversal using prev/curr/next pointers
        return null;
    }

    public static boolean hasCycle(Node head) {
        // TODO: Floyd's slow/fast pointer cycle detection
        return false;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.printList();

        list.delete(2);
        list.printList();

        list.head = reverseLinkedList(list.head);
        list.printList();

        System.out.println("hasCycle: " + hasCycle(list.head));
    }
}
