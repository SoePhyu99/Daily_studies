public class Heapify {
    int[] array = {5, 6, 4, 7, 9, 8};

    public void toArr() {
        for (int i : array) {
            System.out.println(i);
        }
    }

    public int[] heapifyArray() {
        var current = 0;
        while (current < array.length) {
            for (int i = 0; i < array.length; i++) {
                if(array[current] > array[i]){
                    swap(current, i);
                }
            }
            current++;
        }
        return array;
    }
    private void swap(int first, int second) {
        var temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }
}
