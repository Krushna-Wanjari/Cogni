import java.util.Stack;

public class StackQueueProblems {

    public static boolean isBalancedParentheses(String s) {
        // TODO: use a Stack to check matching (){}[]
        return false;
    }

    static class QueueUsingStacks {
        private Stack<Integer> inStack = new Stack<>();
        private Stack<Integer> outStack = new Stack<>();

        public void enqueue(int value) {
            // TODO: push to inStack
        }

        public int dequeue() {
            // TODO: if outStack empty, pour everything from inStack into outStack, then pop
            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println("isBalanced(\"{[()]}\") = " + isBalancedParentheses("{[()]}"));
        System.out.println("isBalanced(\"{[(])}\") = " + isBalancedParentheses("{[(])}"));

        QueueUsingStacks q = new QueueUsingStacks();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        System.out.println("dequeue -> " + q.dequeue()); // should be 1
        System.out.println("dequeue -> " + q.dequeue()); // should be 2
    }
}
