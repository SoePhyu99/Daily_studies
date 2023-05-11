import java.util.Arrays;

public class Deque {
    int[] deque = new int[5];
    private int first = 0;
    private int roar = 0;

    public void enqueue(int item) {
        if(isFull()){
            System.out.println("Full");
        }else{
            deque[roar] = item;
            roar = (roar+1) % deque.length;
        }
    }

    public int dequeue() {
        if(isEmpty()){
            return -1;
        }
        var result = deque[first];
        deque[first] = 0;
        first = (first + 1) % deque.length;
        return result;
    }

    public boolean isFull() {
        return roar == deque.length;
    }

    public boolean isEmpty() {
        return first == deque.length;
    }

    @Override
    public String toString(){
        return Arrays.toString(deque);
    }
}
