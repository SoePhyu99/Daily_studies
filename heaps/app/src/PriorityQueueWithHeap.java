public class PriorityQueueWithHeap{
    Heap heap = new Heap();

    public void enqueue(int item) {
        heap.insert(item);
      }
    
      public void dequeue() {
        heap.remove();
      }
    
      public boolean isEmpty() {
        return heap.isEmpty();
      }
}