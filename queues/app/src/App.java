import java.util.Queue;
import java.util.Stack;

public class App {
    public static void main(String[] args) throws Exception {
        PriorityQueue pri = new PriorityQueue();
        pri.add(4);
        pri.add(5);
        pri.add(6);
        pri.add(1);
        pri.add(2);
        System.out.println(pri.remove());
        System.out.println(pri.remove());
    }

    public static void Reverse(Queue<Integer> queue) {
        int[] arr = new int[queue.size()];
        for (int i = queue.size() - 1; i > -1; i--) {
            arr[i] = queue.remove();
        }
        for (int i : arr) {
            queue.add(i);
        }
        System.out.println(queue);
    }

    public static void Reverse1(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();
        while (!queue.isEmpty()) {
            stack.push(queue.remove());
        }
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
    }
}
