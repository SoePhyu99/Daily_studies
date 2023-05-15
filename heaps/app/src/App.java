public class App {
    public static void main(String[] args) throws Exception {
        Heap heap = new Heap();
        // heap.insert(11);
        heap.insert(10);
        heap.insert(8);
        heap.insert(9);
        heap.insert(7);
        heap.insert(6);
        heap.insert(5);
        heap.insert(4);
        heap.remove();

        var result = heap.toString();
        System.out.println(result);
    }
}
