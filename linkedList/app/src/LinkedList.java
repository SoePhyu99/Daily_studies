public class LinkedList {
    private Node first;
    private Node last;
    private int size;

    private class Node {
        private int value;
        private Node next;
    
        public Node(int value){
            this.value = value;
        }
    }

    // addFirst
    public void addFirst(int item) {
        var node = new Node(item);
        if(first == null){
            first = last = node;
        }else{
            node.next = first;
            first = node;
        }
        size++;
    }

    // addLast
    public void addLast(int item) {
        var node = new Node(item);
        if(first == null){
            last = first = node;
        }else{
            last.next = node;
            last = node;
        }
        size++;
    }

    // deleteFirst
    public void removeFirst(){
        if(isEmpty()){
            System.out.println("Empty!");
        }
        if(first == last){
            first = last = null;
            return;
        }
        var second = first.next;
        first.next = null;
        first = second;
        size--;
    }

    // deleteLast
    public void removeLast(){
        if(isEmpty()){
            System.out.println("Empty!");
        }
        if(first == last){
            first = last = null;
            size = 0;
            return;
        }
        var previous = getPrevious(last);
        last = previous;
        last.next = null;
        size--;
    }
    private Node getPrevious(Node node) {
        var previous = node;
        var current = first;
        while(current != node){
            previous = current;
            current = current.next;
        }
        return previous;
    }
    // contains
    public boolean contains(int item) {
        if(indexOf(item) != -1){
            return true;
        }
        return false;
    }
    // indexOf
    public int indexOf(int item){
        int index = 0;
        var current = first;
        while(current != null){
            if(current.value == item){
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }
    // length
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        if(first == null && last == null){
            return true;
        }
        return false;
    }

    // to array
    public int[] toArray() {
        var current = first;
        int[] listArray = new int[size];
        int index = 0;
        while(current != null){
            listArray[index++] = current.value;
            current = current.next;
        }
        return listArray;
    }

    // reverse 
    public void reverse() {
        var previous = first;
        var current = first.next;
        while(current != null){
            var next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        last = first;
        last.next = null;
        first = previous;
    }
    
    // printMiddle
    public void printMiddle() {
        int index = 0;
        int result = size/2;
        var current = first;
        while (index < result) {
            current = current.next;
            index++;
        }
        System.out.println(current.value);  
    }

    // getKthFromTheEnd
    public int getKthFromTheEnd(int k) {
        if(isEmpty()){
            throw new IllegalStateException();
        }
        if(k == 0 || k == -1){
            throw new IllegalArgumentException();
        }
        else{
            var current = first;
            var second = first;

            for (int i = 0; i < k-1; i++) {
                second = second.next;
                if(second == null){
                    throw new IllegalArgumentException();
                }
            }
            
            while(second != last){
                current = current.next;
                second = second.next;
            }
            System.out.println(current.value);
            return current.value;
        }
    }
}
