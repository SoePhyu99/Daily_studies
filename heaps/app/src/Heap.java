import java.util.Arrays;

public class Heap {
    int[] heap = new int[10];
    private int count = 0;

    @Override
    public String toString() {
        return Arrays.toString(heap);
    }

    public void insert(int item) {
        heap[count++] = item;
        bubbleUp();
    }
    public void remove(){
        heap[0] = 0;
        bubbleDown();
    }
    public boolean isEmpty() {
        return count <= 0;
    }

    private void bubbleUp(){
        var index = count - 1;
        while(index > 0 && heap[index] > heap[parent(index)]){
            changeOrder(index, parent(index));
            index = parent(index);
        }
    }
    private void bubbleDown(){

        changeOrder(0, count - 1);;
        var current = 0;
        while(current <= count && ((hasLeftChild(current) && heap[current] < heap[leftChild(current)]) || (hasRightChild(current) && heap[current] < heap[rightChild(current)]))){
            var largerChildIndex = 0;
            if (heap[leftChild(current)] > heap[rightChild(current)]) {
                largerChildIndex = leftChild(current);
            }
            if(heap[rightChild(current)] > heap[leftChild(current)]){
                largerChildIndex = rightChild(current);
            }
            changeOrder(largerChildIndex, current);
            current = largerChildIndex;
            System.out.println(current);
        }
    }
    private boolean hasLeftChild(int index){
        return leftChild(index) < heap.length;
    }
    private boolean hasRightChild(int index){
        return rightChild(index) < heap.length;
    }
    private int parent(int index){
        return (index - 1) / 2;
    }
    private int leftChild(int index) {
        return (index * 2) + 1;
    }
    private int rightChild(int index) {
        System.out.println(index + "left index");
        return (index * 2) + 2;
    }
    private void changeOrder(int first, int second){
        var current = heap[first];
        heap[first] = heap[second];
        heap[second] = current;
    }
}
