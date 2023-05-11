import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        LinkedList linkedList = new LinkedList();
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);
        linkedList.addLast(4);
        linkedList.addLast(5);
        linkedList.addLast(6);
        // linkedList.reverse();
        var arr = linkedList.toArray();
        System.out.println(Arrays.toString(arr));
        linkedList.getKthFromTheEnd(0);
    }
}
